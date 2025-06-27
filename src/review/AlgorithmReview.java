package review;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class AlgorithmReview {
    public static void main(String[] args) {
        // Búsqueda lineal

        // Búsqueda Binaria

        // Recursividad

        int n = 10;
        long factorial = IntStream.rangeClosed(1, n)
                .asLongStream()
                .reduce(1L, (a, b) -> a * b);;

    }
    
    public static int linearSearch(int[] arr, int target) {
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    public static OptionalInt busquedaLineal(int[] arr, int target) {
        return IntStream.range(0, arr.length)
                .filter(i -> arr[i] == target)
                .findFirst();
    }

    public static int binarySearch(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                lo = mid + 1;
            } else hi = mid - 1;
        }
        return -1;
    }

    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n-1);
    }

}
