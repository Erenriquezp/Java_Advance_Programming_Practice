package practice;

import java.util.*;
import java.util.stream.IntStream;

public class CoprimeFilter {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            int count = readIntInRange(scanner, "Cantidad de números a ingresar (entre 1 y 20): ", 1, 20);
            int max = readIntInRange(scanner, "valor máximo (entre 1 y 40): ", 1, 40);

            List<Integer> original = generateRandomList(count, max);
            Classification result = classifyCoprime(original);

            System.out.println("original = " + original);
            System.out.println("valid = " + result.getValid());
            System.out.println("invalid = " + result.getInvalid());
        } catch (InputMismatchException ime) {
            System.out.println("Entrada no válida: " + ime.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
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
        Random rnd = new Random();
        return IntStream.range(0, count)
                .map(i -> 1 + rnd.nextInt(max))
                .boxed()
                .toList();
    }

    private static Classification classifyCoprime(List<Integer> nums) {
        List<Integer> valid = new ArrayList<>();
        List<Integer> invalid = new ArrayList<>();

        nums.forEach(n -> {
            boolean isCoprime = valid.stream()
                    .allMatch(v -> gcd(n, v) == 1);
            if (isCoprime) valid.add(n);
            else invalid.add(n);
        });

        Collections.sort(valid);
        Collections.sort(invalid);
        return new Classification(valid, invalid);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    private static class Classification {
        private final List<Integer> valid, invalid;

        public Classification(List<Integer> valid, List<Integer> invalid) {
            this.valid = valid;
            this.invalid = invalid;
        }

        public List<Integer> getInvalid() {
            return invalid;
        }

        public List<Integer> getValid() {
            return valid;
        }
    }
}
