package nl.nutstree.romannumerals.try20190302;

public class RomanNumerals {

    public static String arabicToRoman(int input) {
        String result = "";
        int inputLeft = input;

        for (Roman roman : Roman.values()) {
            while (inputLeft - roman.arabic >= 0) {
                inputLeft -= roman.arabic;
                result += roman.name();
            }
        }

        validateRomanResult(result);

        return result;
    }

    private static void validateRomanResult(String result) {
        if (result.equals(""))
            throw new IllegalArgumentException();
    }

    public static int romanToArabic(String input) {
        String inputLeft = input;
        int result = 0;

        for (Roman roman : Roman.values()) {
            while (inputLeft.startsWith(roman.name())) {
                inputLeft = inputLeft.replaceFirst(roman.name(), "");
                result += roman.arabic;
            }
        }

        validateArabicResult(input, result);

        return result;
    }

    private static void validateArabicResult(String input, int result) {
        if (!input.equals(arabicToRoman(result)))
            throw new IllegalArgumentException();
    }

    private enum Roman {
        C(100),
        XC(90),
        L(50),
        XL(40),
        X(10),
        IX(9),
        V(5),
        IV(4),
        I(1);

        private int arabic;

        Roman(int arabic) {
            this.arabic = arabic;
        }
    }
}