package practice;

public class FibonacciRecursivo {

    // Caso base: F(0)=0, F(1)=1; recursivo estándar
    public static long fibRec(int n) {
        if (n < 2) return n;
        return fibRec(n - 1) + fibRec(n - 2);
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci recursivo:");
        for (int i = 0; i <= n; i++) {
            System.out.printf("F(%d) = %d%n", i, fibRec(i));
        }
    }
}
