package retos;

import java.util.ArrayList;
import java.util.List;

public class GeneradorPermutaciones {

    // Metodo principal para generar permutaciones
    public static List<List<Integer>> generarPermutaciones(List<Integer> numeros) {
        List<List<Integer>> resultado = new ArrayList<>();

        if (numeros.isEmpty()) {
            resultado.add(new ArrayList<>()); // Caso base: lista vacía tiene una permutación [] (la lista vacía)
            return resultado;
        }

        // Recorrer cada número en la lista coo punto de partida
        for (int i = 0; i < numeros.size(); i++) {
            Integer actual = numeros.get(i);

            // Crear una nueva lista sin modificar la original
            List<Integer> restantes = new ArrayList<>(numeros);
            restantes.remove(i); // Eliminar el número actual

            // Recursividad: obtener permutaciones de los restantes
            List<List<Integer>> subPermutaciones = generarPermutaciones(restantes);

            // Agregar el número actual al inicio de cada permutación obtenida
            for (List<Integer> sub : subPermutaciones) {
                List<Integer> nuevaPerm = new ArrayList<>();
                nuevaPerm.add(actual);
                nuevaPerm.addAll(sub);
                resultado.add(nuevaPerm);
            }
        }
        return resultado;
    }

    // Método de utilidad para imprimir resultados ordenadamente
    public static void imprimirPermutaciones(List<List<Integer>> permutaciones) {
        System.out.println("[");
        for (List<Integer> p : permutaciones) {
            System.out.println("  " + p + ",");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        List<Integer> original = List.of(1, 2, 3, 4); // Lista original inmutable

        // Test 1: Lista vacía
        System.out.println("Permutaciones de lista vacía:");
        imprimirPermutaciones(generarPermutaciones(List.of()));

        // Test 2: Imprimir original antes y después
        System.out.println("Lista original (debe seguir igual): " + original);
        List<List<Integer>> resultado = generarPermutaciones(original);
        System.out.println("Lista original después (sin cambios): " + original);

        // Test 3: Permutaciones de [1, 2, 3, 4]
        System.out.println("Permutaciones de [1, 2, 3, 4]:");
        imprimirPermutaciones(resultado);
    }
}
