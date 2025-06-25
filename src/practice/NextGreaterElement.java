package practice;

import java.util.*;
import java.util.stream.IntStream;

public class NextGreaterElement {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int count = readIntInRange(sc, "Cantidad de números a ingresar (entre 1 y 20): ", 1, 20);
            int max = readIntInRange(sc, "Valor máximo (entre 1 y 100): ", 1, 100);

            List<Integer> nums = IntStream.range(0, count)
                    .map(i -> 1 + new Random().nextInt(max)) // Genera números aleatorios entre 1 y max
                    .boxed()
                    .toList();

            List<Integer> result = computeNextGreater(nums);
            System.out.println("Números originales: " + nums);
            System.out.println("Siguiente mayor: " + result);
        } catch (InputMismatchException e) {
            System.err.println("Entrada no válida: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }

    private static int readIntInRange(Scanner sc, String prompt, int min, int max) {
        System.out.println(prompt);
        int v = sc.nextInt();
        if (v < min || v > max) {
            throw new IllegalArgumentException("Valor fuera de rango");
        }
        return v;
    }

    private static List<Integer> computeNextGreater(List<Integer> nums) {
        int n = nums.size();
        Integer[] result = new Integer[n];
        Deque<Integer> stack = new ArrayDeque<>();
        // Guardamos los índices en el stack

        for (int i = 0; i < n; i++) {
            // Mientas el actual sea mayor que el de la cima del stack
            // asigna result[top] = nums[i]
            while (!stack.isEmpty() && nums.get(i) > nums.get(stack.peek())) {
                int idx = stack.pop();
                result[idx] = nums.get(i);
            }
            stack.push(i);
        }
        // Los que quedan en el stack no tienen siguiente mayor
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        return Arrays.asList(result);
    }
}
