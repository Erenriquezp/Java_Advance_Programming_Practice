package practice;

public class PalindromoRecursivo {

    // Invierte n recursivamente
    public static long invertir(long n, long invertido) {
        if (n == 0) return invertido;
        long dígito = n % 10;
        return invertir(n / 10, invertido * 10 + dígito);
    }

    public static boolean esPalindromo(long n) {
        if (n < 0) n = -n;  // consideramos el valor absoluto
        return n == invertir(n, 0);
    }

    public static void main(String[] args) {
        long[] nums = {121, 12321, 123, 10, 7, 45654};
        for (long x : nums) {
            System.out.printf("%d → %s%n", x, esPalindromo(x) ? "Palíndromo" : "No palíndromo");
        }
    }
}

