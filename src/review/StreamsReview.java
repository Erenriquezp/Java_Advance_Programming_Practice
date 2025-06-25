package review;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsReview {
    public static void main(String[] args) {
        // Creacion de streams
        List<String> list = List.of("a", "b", "c");
        Stream<String> stream = list.stream();
        Stream<String> parallelStream = list.parallelStream();

        // Desde un array
        IntStream is = Arrays.stream(new int[]{1, 2, 3, 4, 5});

        // Desde valores explícitos
        Stream<String> s = Stream.of("x", "y", "z");

        // Streams infinitos/generados
        Stream<Double> randomStream = Stream.generate(Math::random);
        Stream<Integer> fibs = Stream.iterate(0, n -> n + 1);

        // flatMap
        List<List<String>> listas = List.of(
            List.of("a", "b"),
            List.of("c", "d")
        );

        List<String> combined = listas.stream()
                .flatMap(List::stream)
                .toList();

        // Sorted
        record Alumno(String nombre, double nota) {}
        List<Alumno> alumnos = List.of(
            new Alumno("Ana", 8.5),
            new Alumno("Luis", 9.0),
            new Alumno("Pedro", 7.5)
        );
        List<Alumno> orderedAlumnos = alumnos.stream()
                .sorted(Comparator.comparingDouble(Alumno::nota).reversed()
                        .thenComparing(Alumno::nombre))
                .toList();
        System.out.println(orderedAlumnos);

        // limit
        List<Integer> primerosPares = Stream.iterate(0, n -> n + 2)
                .limit(5)
                .toList();
        System.out.println(primerosPares);

        int suma = List.of(1,2,3,4,5,6).stream()
                .reduce(0, Integer::sum);
        record Punto(int x, int y) {
            Punto plus(Punto o) { return new Punto(x+o.x, y+o.y); }
        }
        Punto cero = new Punto(0, 0);
        Punto sumaPuntos = List.of(new Punto(1,2), new Punto(3,4), new Punto(5,6))
                .stream()
                .reduce(cero, Punto::plus);

        // Collectors
        Deque<String> deque = Stream.of("d", "b", "c")
                .collect(Collector.of(
                        ArrayDeque::new,
                        Deque::add,
                        (dq1, dq2) -> {
                            dq1.addAll(dq2);
                            return dq1;
                        }
                ));
        deque.forEach(System.out::println);

        // anyMatch
        boolean hayPar = IntStream.range(1, 10000)
                .anyMatch(n -> n % 2 == 0);
    }
}
