package practice;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class HeatMap {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int M = readIntInRange(sc, "Cantidad de filas del grid: ", 1, 100);
            int N = readIntInRange(sc, "Cantidad de columnas del grid: ", 1, 100);
            int Tmax = readIntInRange(sc, "Temperatura máxima (Tmax): ", 1, 100);

            int[][] grid = generateGrid(M, N, Tmax);
            int[][] smoothedGrid = smoothGrid(grid);

            System.out.println("Grid original:");
            printGrid(grid);

            System.out.println("Grid suavizado:");
            printGrid(smoothedGrid);
        } catch (InputMismatchException e) {
            System.out.println("Entrada no válida: " + e.getMessage());
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

    private static int[][] generateGrid(int M, int N, int Tmax) {
        Random rnd = new Random();
        return IntStream.range(0, M)
                .mapToObj(i -> rnd.ints(N, 0, Tmax + 1).toArray())
                .toArray(int[][]::new);
    }

    private static int[][] smoothGrid(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        int[][] result = new int[M][N];

        // Desplazamientos relativos de las 8 direcciones + la propia
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int sum = 0, count = 0;
                for (int k = 0; k < 8; k++) {
                    int ni = i + dx[k], nj = j + dy[k];
                    if (ni >= 0 && ni < M && nj >= 0 && nj < N) {
                        sum += grid[ni][nj];
                        count++;
                    }
                }
                result[i][j] = sum / count;
            }
        }
        return result;
    }

    private static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            for (int val : row) {
                System.out.printf("%3d ", val);
            }
            System.out.println();
        }
    }
}
