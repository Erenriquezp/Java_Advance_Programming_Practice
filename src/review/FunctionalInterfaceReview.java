package review;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FunctionalInterfaceReview {
    public static void main(String[] args) {
        // Function> Aplica una transformación a un valor
        Function<String, Integer> length = String::length;
        Stream.of("uno", "dos", "cuatro")
                .map(length)
                .forEach(System.out::println);

        // Composición de funciones
        Function<String, String> upper = String::toUpperCase;
        Function<String, String> lower = s -> s + "!";
        Function<String, String> greet = upper.andThen(lower);
        System.out.println(greet.apply("hola"));

        // Consumer: Realiza una acción con efectos secundarios
        Consumer<String> print = System.out::println;
        Stream.of("uno", "dos", "tres")
                .forEach(print);

        // Supplier: Proporciona un valor sin argumentos
        Supplier<String> saludo = () -> "¡Hola, mundo!";
        System.out.println(saludo.get());

        Stream.generate(() -> "Hello, World!")
                .limit(5)
                .forEach(System.out::println);

    }
}
