package review;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamReview {
    public static void main(String[] args) {
        // Doblar valores
        IntStream.range(1,6).map(i -> i*2).
                forEach(System.out::println);

        // A objetos
        List<String> strs = IntStream.range(1,4)
                .mapToObj(i -> "n"+i)
                .toList();
        System.out.println(strs);

        // Pares entre 1 y 10
        IntStream.rangeClosed(1,10)
                .filter(i -> i % 2 == 0)
                .forEach(System.out::println);

        // Generar divisores de cada numero
        IntStream.of(6,10)
                .flatMap(n -> IntStream.rangeClosed(1, n)
                        .filter(d -> n % d == 0))
                .forEach(System.out::println);

        // Ordenar y truncar
        IntStream.of(5,1,5,3,2,3)
                .distinct().sorted()
                .limit(3).forEach(System.out::print);

        int sumaTotal = IntStream.rangeClosed(1,100).sum();
        System.out.println("sumaTotal = " + sumaTotal);

        double avg = IntStream.of(2,3,4,5,6)
                .average().orElse(0);
        System.out.println("avg = " + avg);

        long cnt = IntStream.of(1,2,3,4).count();
        System.out.println("cnt = " + cnt);

        int max = IntStream.of(7,3,4,9,1).max().orElse(-1);
        System.out.println("max = " + max);

        // Producto
        int prod = IntStream.rangeClosed(1,5).reduce(1, (a, b) -> a * b);
        System.out.println("prod = " + prod);

        // Para pasar a colecciones
        Integer[] arr = IntStream.range(0,3).boxed().toArray(Integer[]::new);
        List<Integer> list = IntStream.range(0,3).boxed().toList();

        // Fibonacci tabulado
        int n = 10;
        int[] f = new int[n+1]; f[0] = 0; f[1] = 1;
        IntStream.rangeClosed(2,n)
                .forEach(i -> f[i] = f[i-1] + f[i-2]);
        System.out.println("Fibonacci hasta " + n + ": " + IntStream.of(f).boxed().toList());

        // Todos los pares (i, j) con i < j < n
        int nPairs = 5;
        List<int[]> pairs = IntStream.range(0, nPairs)
                .boxed()
                .flatMap(i -> IntStream.range(i+1, nPairs)
                        .mapToObj(j -> new int[]{i, j}))
                .toList();
        System.out.println("Pares (i, j) con i < j < " + nPairs );
        pairs.forEach(p -> System.out.println(p[0] + ", " + p[1]));

        // Contar dijitos de un número
        String s = "1223333334";
        Map<Character, Long> freq = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Frecuencia de dígitos: " + freq);
    }

    public static boolean isPrime(int n) {
        return n > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(n))
                .noneMatch(i -> n % i == 0);
    }
}
