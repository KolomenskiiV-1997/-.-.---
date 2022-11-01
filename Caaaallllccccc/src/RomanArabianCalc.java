//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package calcRA;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RomanArabianCalc {
    static Scanner scanner;
    static int number1;
    static int number2;
    static char operation;
    static int result;

    public RomanArabianCalc() {
    }

    public static void main(String[] args) {
        System.out.println("Введите выражение [2+2] или два римских числа от I до X:[V+V] + Enter ");
        String userInput = scanner.nextLine();
        char[] under_char = new char[10];

        for(int i = 0; i < userInput.length(); i++) {
            under_char[i] = userInput.charAt(i);
            if (under_char[i] == '+') {
                operation = '+';
            }

            if (under_char[i] == '-') {
                operation = '-';
            }

            if (under_char[i] == '*') {
                operation = '*';
            }

            if (under_char[i] == '/') {
                operation = '/';
            }
        }

        String under_charString = String.valueOf(under_char);
        String[] blacks = under_charString.split("[+-/*]");
        String stable00 = blacks[0];
        String stable01 = blacks[1];
        String string03 = stable01.trim();
        number1 = romanToNumber(stable00);
        number2 = romanToNumber(string03);
        if (number1 < 0 && number2 < 0) {
            result = 0;
        } else {
            result = calculated(number1, number2, operation);
            System.out.println("---Результат для римских цифр----");
            String resultRoman = convertNumToRoman(result);
            System.out.println(stable00 + " " + operation + " " + string03 + " = " + resultRoman);
        }

        number2 = Integer.parseInt(string03);
        result = calculated(number1, number2, operation);
        System.out.println("--Результат для арабских цифр----");
        System.out.println(number1 + " " + operation + " " + number2 + " = " + result);
    }

    private static String convertNumToRoman(int numArabian) {
        String[] roman = new String[]{"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        String s = roman[numArabian];
        return s;
    }

    private static int romanToNumber(String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else {
                return roman.equals("X") ? 10 : -1;
            }
        } catch (InputMismatchException var2) {
            throw new InputMismatchException("Неверный формат данных");
        }
    }

    public static int calculated(int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '*':
                result = num1 * num2;
                break;
            case '+':
                result = num1 + num2;
                break;
            case ',':
            case '.':
            default:
                throw new IllegalArgumentException("Не верный знак операции");
            case '-':
                result = num1 - num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (InputMismatchException | ArithmeticException var5) {
                    System.out.println("Exception : " + var5);
                    System.out.println("Only integer non-zero parameters allowed");
                }
        }

        return result;
    }

    static {
        scanner = new Scanner(System.in);
    }
}

