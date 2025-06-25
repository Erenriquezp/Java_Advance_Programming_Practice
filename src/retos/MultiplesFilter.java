package retos;

import java.util.*;
import java.util.stream.IntStream;

public class MultiplesFilter {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            int count = readIntRange(scanner, "Cantidad de números a ingresar (entre 1 y 20): ", 1, 20);
            int max = readIntRange(scanner, "Valor máximo (entre 1 y 40): ", 1, 40);

            List<Integer> original = generateRandomList(count, max);
            Classification result = classifyByPreviousValid(original);

            System.out.println("original = " + original);
            System.out.println("valid = " + result.getValid());
            System.out.println("invalid = " + result.getInvalid());

        } catch (InputMismatchException e) {
            System.out.println("Entrada no válida: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }

    }

    // Lee un entero dentro de un rango, lanza excepción si no es válido
    private static int readIntRange(Scanner sc, String prompt, int min, int max) {
        System.out.println(prompt);
        int val = sc.nextInt();
        if (val < min || val > max) {
            throw new InputMismatchException("Valor fuera de rango");
        }
        return val;
    }

    // Genera una lista de enteros aleatorios
    private static List<Integer> generateRandomList(int count, int max) {
        Random rnd = new Random();
        return IntStream.range(0, count)
                .map(i -> 1 + rnd.nextInt(max))
                .boxed()
                .toList();
    }

    // Clasifica los números según si es múltiplo de alguno de los validos anteriores
    private static Classification classifyByPreviousValid(List<Integer> numbers) {
        List<Integer> valid = new ArrayList<>();
        List<Integer> invalid = new ArrayList<>();

        // Para cada número, verifica si es múltiplo de algún número válido anterior
        numbers.forEach(n -> {
            boolean isMultipleOf = valid.stream()
                    .anyMatch(v -> n % v == 0);
            if (isMultipleOf) invalid.add(n);
            else valid.add(n);
        });

        // Ordenamos y retornamos
        Collections.sort(valid);
        Collections.sort(invalid);
        return new Classification(valid, invalid);
    }

    private static class Classification {
        private final List<Integer> valid = new ArrayList<>();;
        private final List<Integer> invalid = new ArrayList<>();

        public Classification(List<Integer> valid, List<Integer> invalid) {
            this.valid.addAll(valid);
            this.invalid.addAll(invalid);
        }

        public List<Integer> getValid() { return valid; }
        public List<Integer> getInvalid() { return invalid; }
    }
}
