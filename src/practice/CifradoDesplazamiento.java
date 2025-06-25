package practice;

import java.util.*;
import java.util.stream.Collectors;

public class CifradoDesplazamiento {

    private static final List<Character> ALPHABET_LOWER = Arrays.asList(
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    );

    private static final List<Character> ALPHABET_UPPER = ALPHABET_LOWER.stream()
            .map(Character::toUpperCase).toList();

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingrese el texto a cifrar:");
            String texto = sc.nextLine();

            System.out.println("Ingrese el desplazamiento (número entero no negativo):");
            int desplazamiento = leerDesplazamiento(sc);

            String cifrado = cifrar(texto, desplazamiento);
            System.out.println("Texto cifrado: " + cifrado);

            System.out.println(28 % 27); // Ejemplo de uso de módulo
            System.out.println(8 % 27); // Ejemplo de uso de módulo
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Lee el desplazamiento con validación
    private static int leerDesplazamiento(Scanner sc) {
        try {
            int d = sc.nextInt();
            if (d < 0) throw new IllegalArgumentException("El desplazamiento no puede ser negativo");
            return d;
        } catch (InputMismatchException e) {
            sc.nextLine(); // Limpiar el buffer
            throw new InputMismatchException("El desplazamiento debe ser un número entero");
        }
    }

    // Desplaza un carácter según el desplazamiento
    private static char desplazar(char c, int d, List<Character> alphabet) {
        int pos = alphabet.indexOf(c);
        int newPos = (pos + d) % alphabet.size();
        return alphabet.get(newPos);
    }

    // Cifrar un caracter individualmente
    private static char cifrarCaracter(char c, int d) {
        if (ALPHABET_LOWER.contains(c)) {
            return desplazar(c, d, ALPHABET_LOWER);
        } else if (ALPHABET_UPPER.contains(c)) {
            return desplazar(c, d, ALPHABET_UPPER);
        } else {
            return c; // No es una letra del alfabeto, no se cifra
        }
    }
    // Cifra el texto con el desplazamiento dado
    private static String cifrar(String texto, int d) {
        return texto.chars()
                .mapToObj(c -> cifrarCaracter((char) c, d))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
