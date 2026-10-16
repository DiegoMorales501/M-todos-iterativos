# Métodos Iterativos: Jacobi y Gauss-Seidel

Programa en Java que resuelve un sistema de ecuaciones de 3×3 con dos métodos iterativos: **Jacobi** y **Gauss-Seidel**. Parten de una aproximación inicial y la mejoran en cada iteración hasta que el cambio entre una vuelta y la siguiente es menor que la tolerancia.

## El sistema

```
5x +  y +  z = 7
 x + 4y +  z = 6
 x + 2y + 5z = 8
```

- Punto de partida: X(0) = [0, 0, 0]
- Tolerancia: ε = 0.0001
- Máximo de iteraciones: 100
- Solución exacta: x = y = z = 1

La matriz es diagonalmente dominante, lo que garantiza que ambos métodos converjan.

## Diferencia entre los métodos

- **Jacobi:** calcula la nueva aproximación usando solo los valores de la iteración anterior.
- **Gauss-Seidel:** usa de inmediato cada valor recién calculado, por lo que converge más rápido.

El programa se detiene cuando la mayor diferencia entre dos iteraciones consecutivas es menor que ε.

## Archivos

| Archivo | Función |
|---------|---------|
| `Defmatriz.java` | Define la matriz A, el vector b, X(0) y la tolerancia |
| `MetodosIterativos.java` | Implementa Jacobi, Gauss-Seidel y el cálculo del error |
| `MainJacobi.java` | Ejecuta el método de Jacobi |
| `MainGaussSeidel.java` | Ejecuta el método de Gauss-Seidel |

Los cuatro archivos deben estar dentro de una carpeta llamada `EcuacionesLineales/`.

## Compilación y ejecución

Requiere JDK 8 o superior. Desde la carpeta que contiene `EcuacionesLineales/`:

```bash
# Compilar
javac EcuacionesLineales/*.java

# Ejecutar
java EcuacionesLineales.MainJacobi
java EcuacionesLineales.MainGaussSeidel
```

## Resultados

| Método | Solución aproximada | Iteraciones |
|--------|---------------------|-------------|
| Jacobi | `[ 0.99999 0.99998 0.99998 ]` | 16 |
| Gauss-Seidel | `[ 0.99999 1.00000 1.00000 ]` | 6 |

Las soluciones son muy cercanas a (1, 1, 1) y no exactas, porque los métodos se detienen al cumplir la tolerancia.