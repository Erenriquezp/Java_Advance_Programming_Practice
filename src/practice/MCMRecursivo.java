package practice;

public class MCMRecursivo {

    // Reusa el GCD por Euclides
    public static int mcd(int a, int b) {
        return b == 0 ? Math.abs(a) : mcd(b, a % b);
    }

    // MCM(a,b) = |a·b| / GCD(a,b)
    public static long mcm(int a, int b) {
        if (a == 0 || b == 0) return 0;
        return Math.abs((long)a * b) / mcd(a, b);
    }

    public static void main(String[] args) {
        int[][] pares = { {4, 6}, {21, 6}, {8, 5}, {0, 10}, {-3, 7} };
        for (var par : pares) {
            int a = par[0], b = par[1];
            System.out.printf("mcm(%d, %d) = %d%n", a, b, mcm(a, b));
        }
    }
}
