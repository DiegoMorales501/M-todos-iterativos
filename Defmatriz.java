package EcuacionesLineales;

/**
 * Módulo 1: Definición del Sistema.
 * Centraliza los datos del problema para que ambos métodos usen exactamente lo mismo:
 *
 *   5x +  y +  z = 7
 *    x + 4y +  z = 6
 *    x + 2y + 5z = 8
 */
public class Defmatriz {
    // Matriz de coeficientes A: cada fila es una ecuación, cada columna una incógnita (x, y, z)
    // Es diagonalmente dominante (5 > 1+1, 4 > 1+1, 5 > 1+2), lo que garantiza la convergencia
        public static double[][] obtenerMatrizA() {
            return new double[][] {
                    {5.0, 1.0, 1.0},
                    {1.0, 4.0, 1.0},
                    {1.0, 2.0, 5.0}
            };
        }

        public static double[] obtenerVectorB() { return new double[] {7.0, 6.0, 8.0}; }

        public static double[] obtenerVectorX0() { return new double[] {0.0, 0.0, 0.0}; }

        // Tolerancia de error establecida (ε = 0.0001)
        public static double obtenerTolerancia() { return 0.0001; }

}
