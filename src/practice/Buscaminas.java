package practice;
import java.util.*;

public class Buscaminas {

    public static void main(String[] args) {
        int W = 16, H = 7;
        double probMina = 0.2;  // p.ej. 20% de celdas con mina

        boolean[][] minas = generarTablero(W, H, probMina);
        int[][] conteos = calcularVecinos(minas);

        System.out.println("=== Tablero de Minas (B = mina) ===");
        imprimirBoolean(minas);
        System.out.println("\n=== Conteo de Vecinos ===");
        imprimirEnteros(conteos);
    }

    /** 1) Genera un tablero H×W, cada celda con mina con probabilidad p */
    public static boolean[][] generarTablero(int W, int H, double p) {
        Random rnd = new Random();
        boolean[][] tablero = new boolean[H][W];
        for (int y = 0; y < H; y++) {
            for (int x = 0; x < W; x++) {
                tablero[y][x] = rnd.nextDouble() < p;
            }
        }
        return tablero;
    }

    /** 2) A partir del tablero de booleanos calcula el número de minas adyacentes */
    public static int[][] calcularVecinos(boolean[][] minas) {
        int H = minas.length, W = minas[0].length;
        int[][] vec = new int[H][W];

        // desplazamientos relativos de las 8 direcciones
        int[] dx = { -1, 0, 1, -1, 1, -1, 0, 1 };
        int[] dy = { -1,-1,-1,  0, 0,  1, 1, 1 };

        for (int y = 0; y < H; y++) {
            for (int x = 0; x < W; x++) {
                if (minas[y][x]) {
                    vec[y][x] = -1; // marca mina
                } else {
                    int count = 0;
                    for (int k = 0; k < 8; k++) {
                        int nx = x + dx[k], ny = y + dy[k];
                        if (nx >= 0 && nx < W && ny >= 0 && ny < H && minas[ny][nx]) {
                            count++;
                        }
                    }
                    vec[y][x] = count;
                }
            }
        }
        return vec;
    }

    /** 3a) Imprime un tablero booleano: ‘B’ para mina, ‘.’ para vacío */
    public static void imprimirBoolean(boolean[][] board) {
        for (boolean[] fila : board) {
            for (boolean celda : fila) {
                System.out.print(celda ? "B " : ". ");
            }
            System.out.println();
        }
    }

    /** 3b) Imprime un tablero de enteros; mina marcada como ‘B’ */
    public static void imprimirEnteros(int[][] board) {
        for (int[] fila : board) {
            for (int val : fila) {
                System.out.print((val < 0 ? "B" : val) + " ");
            }
            System.out.println();
        }
    }
}
