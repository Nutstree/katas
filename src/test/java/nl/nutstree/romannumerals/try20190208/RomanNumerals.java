package nl.nutstree.romannumerals.try20190208;

import org.apache.commons.lang3.Validate;

import java.util.List;
import java.util.stream.Stream;

public class RomanNumerals {
    private static final List<String> legalRomans = List.of("", "I", "V", "X", "L", "C", "D", "M");
    private static final String PER_CHAR = "";

    private RomanNumerals() {
        // util class
    }

    public static int convert(String roman) {
        validate(roman);

        return roman.length();
    }

    private static void validate(String roman) {
        Validate.notNull(roman);

        if (isValidRoman(roman))
            throw new IllegalArgumentException();
    }

    private static boolean isValidRoman(String roman) {
        return !Stream.of(roman.split(PER_CHAR))
                .allMatch(legalRomans::contains);
    }
}
