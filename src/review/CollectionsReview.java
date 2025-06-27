package review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionsReview {
    public static void main(String[] args) {
        // Ordenar y buscar
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Collections.sort(nums);
        int index = Collections.binarySearch(nums, 5);
        System.out.println("Sorted list: " + nums);
        System.out.println("Index of 5: " + index);

        // Frecuencias en listas pequeñas
        List<String> letters = Arrays.asList("a", "b", "c", "a", "b", "a");
        int countA = Collections.frequency(letters, "a");
        System.out.println("Letters: " + letters);
        System.out.println("Frequency of 'a': " + countA);

        // Rotar lista
        List<Integer> arr = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        Collections.rotate(arr, 2);
        System.out.println("Rotated list: " + arr);

        // Mezclar lista
        List<Integer> baraja = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        Collections.shuffle(baraja);
        System.out.println("Shuffled deck: " + baraja);

        // Obtener valor máximo personalizado
        String maxName = Collections.max(List.of("Ana", "Zwq", "Zoe"));
        System.out.println("Max name: " + maxName);
    }
}
