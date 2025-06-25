package practice;

import java.util.*;
import java.util.stream.IntStream;

public class ReverseFilter {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int count = readIntInRange(sc, "Cantidad de números a ingresar (entre 1 y 20): ", 1, 20);
            int max = readIntInRange(sc, "Valor máximo (entre 1 y 100): ", 1, 100);

            List<Integer> original = generateRandomList(count, max);
            Classification result = classifyByReversed(original);

            System.out.println("original = " + original);
            System.out.println("valid = " + result.getValid());
            System.out.println("invalid = " + result.getInvalid());
        } catch (InputMismatchException e) {
            System.err.println("Entrada no válida: " + e.getMessage());
        }
    }

    private static int readIntInRange(Scanner sc, String prompt, int min, int max) {
        System.out.println(prompt);
        int val = sc.nextInt();
        if (val < min || val > max) {
            throw new InputMismatchException("Valor fuera de rango");
        }
        return val;
    }

    private static List<Integer> generateRandomList(int count, int max) {
        Random rd = new Random();
        return IntStream.range(0, count)
                .map(i -> 1 + rd.nextInt(max))
                .boxed()
                .toList();
    }

    private static Classification classifyByReversed(List<Integer> nums) {
        List<Integer> valid = new ArrayList<>();
        List<Integer> invalid = new ArrayList<>();

        nums.forEach(n -> {
            boolean hasReversed = valid.stream()
                    .anyMatch(v -> reverse(n) == v);
            if (hasReversed) invalid.add(n);
            else valid.add(n);
        });

        Collections.sort(valid);
        Collections.sort(invalid);
        return new Classification(valid, invalid);
    }

    // Invierte los dígitos de n (123 -> 321)
    private static int reverse(int n) {
        int r = 0;
        while (n > 0) {
            r = r *10 + (n % 10);
            n /= 10;
        }
        return r;
    }

    private static class Classification {
        private final List<Integer> valid, invalid;

        public Classification(List<Integer> valid, List<Integer> invalid) {
            this.valid = valid;
            this.invalid = invalid;
        }

        public List<Integer> getValid() {
            return valid;
        }

        public List<Integer> getInvalid() {
            return invalid;
        }
    }
}
