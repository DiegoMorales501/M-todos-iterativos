package EcuacionesLineales;

import EcuacionesLineales.Defmatriz;
import EcuacionesLineales.MetodosIterativos;

public class MainGaussSeidel {

    public static void main(String[] args) {
        // Reciclamos A, b, X(0) y la tolerancia directamente desde Defmatrix
        double[][] A = Defmatriz.obtenerMatrizA();
        double[] b = Defmatriz.obtenerVectorB();
        double[] xInicial = Defmatriz.obtenerVectorX0();
        double tol = Defmatriz.obtenerTolerancia();

        // Número máximo de iteraciones
        int maxIter = 100;

        // Llamada al método de Gauss-Seidel
        double[] resultado = MetodosIterativos.gaussSeidel(A, b, xInicial, tol, maxIter);

        // Imprimir los resultados por consola
        System.out.println("Método de Gauss-Seidel");
        System.out.print("Solución aproximada: [ ");
        for (double val : resultado) {
            System.out.printf("%.5f ", val);
        }
        System.out.println("]");
        System.out.println("Iteraciones: " + MetodosIterativos.obtenerIteraciones());
    }
}
