package practice;

public class FactorialRecursivo {

    // Caso base: 0! = 1; recursivo estándar
    public static long factRec(int n) {
        if (n <= 1) return 1;
        return n * factRec(n - 1);
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Factorial recursivo:");
        for (int i = 0; i <= n; i++) {
            System.out.printf("%d! = %d%n", i, factRec(i));
        }
    }
}

