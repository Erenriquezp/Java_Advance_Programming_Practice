package review;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AlgorithmReview2 {
    public static void main(String[] args) {
        // Busqueda lineal
        List<String> names = List.of("Anna", "Nino", "Nino", "Miku", "Mio", "Mio");
        Optional<String> name = names.stream()
                .filter(n -> n.equals("Mio"))
                .findFirst();

        System.out.println(name.orElse("Not found"));

        // Al menos una coincidencia
        boolean hayMio = names.stream()
                .anyMatch(n -> n.equals("Mio"));

        // Recursividad con streams
        // Factorial con reduce
        int n = 5;
        int factorial = IntStream.rangeClosed(1, n)
                .reduce(1, (a, b) -> a *b);
        System.out.println("factorial = " + factorial);

        // Ordenamiento funcional
        record Persona(String name, int age) {}
        List<Persona> personas = List.of(
                new Persona("Ana", 30),
                new Persona("Luis", 25),
                new Persona("Pedro", 35)
        );
        List<Persona> orderedPersonas = personas.stream()
                .sorted(Comparator.comparing(Persona::age))
                .toList();
        System.out.println("Ordered Personas: " + orderedPersonas);

        // Ordenar por múltiples criterios
        Comparator<Persona> comparator = Comparator
                .comparingInt(Persona::age)
                .thenComparing(Persona::name);
        List<Persona> orderedByMultipleCriteria = personas.stream()
                .sorted(comparator)
                .toList();

        // Palabras duplicadas en una lista
        List<String> palabras = List.of("java", "python", "java", "c++", "python", "java");
        Set<String> duplicates = palabras.stream()
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println(duplicates);

        // Palabras más frecuentes
        List<String> text = List.of("hola", "mundo", "hola", "java", "java", "mundo", "java");
        Map<String, Long> frecuencias = text.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        frecuencias.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        // Eliminar duplicados y conservar el orden
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
        List<Integer> withoutDuplicates = nums.stream()
                .distinct()
                .toList();

        // Números primos usando IntStream
        List<Integer> primes = IntStream.rangeClosed(2, 100)
                .filter(n1 -> IntStream.rangeClosed(2, (int) Math.sqrt(n1))
                        .noneMatch(i -> n1 % i == 0))
                .boxed()
                .toList();

    }
}
