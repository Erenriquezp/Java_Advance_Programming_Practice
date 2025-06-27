package practice;

public class MCDRecursivo {

    /**
     * Devuelve el máximo común divisor de a y b
     * usando la forma recursiva del algoritmo de Euclides.
     */
    public static int mcd(int a, int b) {
        if (b == 0) return Math.abs(a);
        return mcd(b, a % b);
    }

    public static void main(String[] args) {
        int[][] pares = { {48, 18}, {100, 25}, {7, 3}, {20, 30}, {-42, 56} };
        for (var par : pares) {
            int a = par[0], b = par[1];
            System.out.printf("mcd(%d, %d) = %d%n", a, b, mcd(a, b));
        }
    }
}
