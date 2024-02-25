package classes;

import java.util.Scanner;

public class Util {
    public static Scanner scanner = new Scanner(System.in);

    public static Integer persistStringToInteger(String errorMessage) {
        String inputText = scanner.nextLine();
        while (tryParseInt(inputText) == null) {
            System.err.println(errorMessage);
            inputText = scanner.nextLine();
        }
        return tryParseInt(inputText);
    }
    public static Integer persistIntegerInterval(Integer minimunValue, Integer maximumValue, String errorMessage) {
        Integer inputNumber = persistStringToInteger(
                "O número inserido é inválido, por favor insira um valor inteiro válido:");
        while (inputNumber < minimunValue || inputNumber > maximumValue) {
            System.err.println(errorMessage);
            inputNumber = persistStringToInteger(
                    "O número inserido é inválido, por favor insira um valor inteiro válido:");
        }
        return inputNumber;
    }

    public static Integer tryParseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
