package EcuacionesLineales;

public class MainJacobi {
    public static void main(String[] args) {
        // Módulo 1: cargamos los datos del sistema desde Defmatriz
        double[][] A = Defmatriz.obtenerMatrizA();   // Coeficientes
        double[] b = Defmatriz.obtenerVectorB();     // Términos independientes
        double[] x0 = Defmatriz.obtenerVectorX0();   // Punto de partida
        double tol = Defmatriz.obtenerTolerancia();  // Precisión deseada (ε)

        int maxIter = 100;  // Límite de seguridad por si el método no converge

        // Módulo 2: resolvemos el sistema con el método iterativo
        double[] solucion = MetodosIterativos.jacobi(A, b, x0, tol, maxIter);

        // Módulo 3: mostramos resultados
        System.out.println("Método de Jacobi");
        System.out.print("Solución aproximada: [ ");
        for (double val : solucion) {
            System.out.printf("%.5f ", val);         // 5 decimales, acorde con ε = 0.0001
        }
        System.out.println("]");
        System.out.println("Iteraciones: " + MetodosIterativos.obtenerIteraciones());
    }
}
