package practice;

public class PrimoRecursivo {

    // Comprueba si n es primo probando divisores desde 2 hasta sqrt(n)
    public static boolean esPrimoRec(int n) {
        if (n < 2) return false;
        return esPrimoRec(n, 2);
    }

    private static boolean esPrimoRec(int n, int div) {
        if (div * div > n) return true;            // ningún divisor encontrado
        if (n % div == 0) return false;            // encontrado divisor
        return esPrimoRec(n, div + 1);             // probar siguiente
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 16, 17, 19, 20};
        for (int n : nums) {
            System.out.printf("%d → %s%n", n,
                    esPrimoRec(n) ? "Primo" : "No primo");
        }
    }
}
