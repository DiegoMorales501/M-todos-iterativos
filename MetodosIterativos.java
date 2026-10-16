package EcuacionesLineales;

public class MetodosIterativos {

    // Contador compartido: guarda cuántas vueltas dio el último método ejecutado
    private static int iteraciones = 0;

    // Permite que los Main consulten el contador sin modificarlo
    public static int obtenerIteraciones() {
        return iteraciones;
    }

    /**
     * MÉTODO DE JACOBI
     * Calcula toda la nueva aproximación usando SOLO valores de la iteración anterior.
     */
    public static double[] jacobi(double[][] A, double[] b, double[] x0, double tol, int maxIter) {
        int n = b.length;                   // Número de ecuaciones/incógnitas
        double[] x = x0.clone();            // Aproximación actual (copia para no alterar x0)
        double[] xNuevo = new double[n];    // Aquí se construye la siguiente aproximación
        iteraciones = 0;                    // Reiniciamos el contador en cada llamada

        // Ciclo principal: se repite hasta converger o hasta agotar maxIter (evita ciclos infinitos)
        for (int k = 0; k < maxIter; k++) {
            iteraciones++;

            for (int i = 0; i < n; i++) {       // Recorremos cada ecuación (fila)
                double suma = 0.0;              // Se reinicia en cada fila

                for (int j = 0; j < n; j++) {   // Recorremos cada coeficiente (columna)
                    if (j != i) {               // Se excluye la diagonal: ese término es el que despejamos
                        suma += A[i][j] * x[j]; // x[j] pertenece a la iteración anterior
                    }
                }

                // Despeje: x_i = (b_i - Σ a_ij * x_j) / a_ii
                xNuevo[i] = (b[i] - suma) / A[i][i];
            }

            // Criterio de paro: si el cambio máximo entre iteraciones es menor que ε, ya convergió
            if (calcularError(x, xNuevo) < tol) {
                return xNuevo;
            }

            // Si no convergió, la nueva aproximación pasa a ser la actual para la siguiente vuelta
            x = xNuevo.clone();
        }

        // Si se agotaron las iteraciones, devolvemos la última aproximación obtenida
        return xNuevo;
    }

    /**
     * MÉTODO DE GAUSS-SEIDEL
     * Igual que Jacobi, pero cada valor recién calculado se usa de inmediato
     * en las ecuaciones siguientes de la misma iteración.
     */
    public static double[] gaussSeidel(double[][] A, double[] b, double[] xInicial, double tol, int maxIter) {
        int n = xInicial.length;
        double[] x = xInicial.clone();      // Un solo vector que se actualiza sobre la marcha
        iteraciones = 0;

        for (int iter = 0; iter < maxIter; iter++) {
            iteraciones++;

            // Guardamos el estado anterior, porque x se va a sobrescribir y lo necesitamos para medir el error
            double[] xAnt = x.clone();

            for (int i = 0; i < n; i++) {
                double suma = b[i];         // Partimos del término independiente

                for (int j = 0; j < n; j++) {
                    if (j != i) {           // Se omite la diagonal
                        suma -= A[i][j] * x[j];  // x[j] ya puede ser un valor nuevo si j < i
                    }
                }

                x[i] = suma / A[i][i];      // Se guarda de inmediato: esta es la diferencia clave con Jacobi
            }

            // Comparamos el vector viejo con el recién calculado
            if (calcularError(xAnt, x) < tol) {
                return x;
            }
        }

        // Si no convergió en maxIter, devuelve la mejor aproximación disponible
        return x;
    }

    /**
     * Error = norma infinito de la diferencia: max |xNuevo[i] - xAnt[i]|
     * Mide cuánto cambió la componente que más se movió entre dos iteraciones.
     */
    public static double calcularError(double[] xAnt, double[] xNuevo) {
        double max = 0.0;
        for (int i = 0; i < xAnt.length; i++) {
            max = Math.max(max, Math.abs(xNuevo[i] - xAnt[i]));  // Nos quedamos con la mayor diferencia
        }
        return max;
    }
}