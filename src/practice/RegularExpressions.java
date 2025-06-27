package practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {
    public static void main(String[] args) {
        // ^        // $: Inicio y fin de línea
        // * cero o más repeticiones // + una o más repeticiones
        // ? cero o una repetición
        // {n} exactamente n repeticiones
        // {n,} al menos n repeticiones
        // {n,m} entre n y m repeticiones

        // . Cualquier carácter excepto salto de línea
        // [abc] cualquiera de los caracteres a, b o c
        // [^abc] cualquiera de los caracteres excepto a, b o c
        // [a-z] cualquier carácter entre a y z (rango)
        // [0-9] cualquier dígito del 0 al 9
        // [a-zA-Z0-9_] cualquier letra mayúscula o minúscula, dígito o guion bajo

        // \d dígito (equivalente a [0-9])
        // \D no dígito (equivalente a [^0-9])
        // \w letra, dígito o guion bajo (equivalente a [a-zA-Z0-9_])
        // \W no letra, dígito ni guion bajo (equivalente a [^a-zA-Z0-9_])
        // \s espacio en blanco (espacio, tabulación, salto de línea)
        // \S no espacio en blanco

        // (?=.*[a-z]) al menos una letra minúscula
        // (?=.*[A-Z]) al menos una letra mayúscula
        // (?=.*\\d) al menos un dígito
        // (?=.*[!@#$%^&*_.\\-]) al menos un carácter especial

        // 1. Validar un correo electrónico
        String regexCorreo = "^[\\w.]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        String correo = "usuario@uce.edu.ec";

        Pattern pat = Pattern.compile(regexCorreo);
        Matcher matcher = pat.matcher(correo);
        if (matcher.matches()) System.out.println("El correo es válido");
        else System.out.println("El correo no es válido");

        // 2. Validar una contraseña

        String regexPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*_.\\-]).{8,16}$";
        String password = "Contraseña123!";

        Pattern patPassword = Pattern.compile(regexPassword);
        Matcher matcherPassword = patPassword.matcher(password);

        if (matcherPassword.matches()) {
            System.out.println("La contraseña es válida");
        } else {
            System.out.println("La contraseña no es válida");
        }

        // Validar cedula ecuatoriana
        String regexCedula = "^\\d{10}$";
        String cedula = "12345-67890";

        Pattern patCedula = Pattern.compile(regexCedula);
        Matcher matcherCedula = patCedula.matcher(cedula);

        if (matcherCedula.matches()) {
            System.out.println("La cédula es válida");
        } else {
            System.out.println("La cédula no es válida");
        }

        // Validar fecha en formato dd/mm/yyyy
        // 0[1-9] Dias del 01 al 09
        // [12][0-9] Dias del 10 al 29
        // 3[01] Dias del 30 al 31

        String regexFecha = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$";

        // Validar número de celular ecuatoriano
        String regexCelularEc = "^09\\d{8}$";

        // Validar número de teléfono fijo ecuatoriano
        String regexTelefonoFijoEc = "^(0[2-7])\\d{7}$";

        // Validar nombres con tildes y espacios
        String regexNombre = "^[A-Za-zÁÉÍÓÚÑáéíóúñ ]{2,50}$";

        // Validar URL
        String regexUrl = "^(https?://)?(www\\.)?[a-zA-Z0-9-]+(\\.[a-zA-Z]{2,})+(/.*)?$";

        // Validar placa de vehículo ecuatoriano
        String regexPlaca = "^[A-Z]{3}-\\d{4}$";

        // Validar hora en formato 24 horas
        String regexHora24h = "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$";

        // Validar IP Ipv4
        String regexIP = "^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)(\\.)){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";

    }
}
