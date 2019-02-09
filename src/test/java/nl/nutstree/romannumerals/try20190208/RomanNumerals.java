package nl.nutstree.romannumerals.try20190208;

import org.apache.commons.lang3.Validate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RomanNumerals {
    private enum Roman {
        I(1),
        V(5),
        X(10),
        L(50),
        C(100),
        D(500),
        M(1000);

        private int numeralValue;

        Roman(int numeralValue) {
            this.numeralValue = numeralValue;
        }

        public int toNumeral() {
            return numeralValue;
        }

        public static Roman fromValue(String roman) {
            return Stream.of(Roman.values())
                    .filter(r -> r.name().equals(roman))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }

        static List<Roman> getAll() {
            return Stream.of(Roman.values())
                    .collect(Collectors.toList());
        }

        static List<Roman> getSpecialRomans() {
            return List.of(V, L, D);
        }
    }

    private static final String PER_CHAR = "";

    private RomanNumerals() {
        // util class
    }

    public static int convert(String roman) {
        Validate.notBlank(roman);
        validateSpecialCharsExistOnlyOnce(roman);
        validateRomanOccurenceCorrect(roman);
        validateRomanOrdering(roman);

        int total = 0;
        Roman last = null;
        List<Roman> romans = toRomanList(roman);
        for (int i = 0; i < romans.size(); i++) {
            Roman current = romans.get(i);
            total += current.numeralValue;
        }
        return total;

//        return toRomanList(roman).stream()
//                .mapToInt(Roman::toNumeral)
//                .sum();
    }

    private static void validateRomanOrdering(String romanString) {
        int last = Integer.MAX_VALUE;
        for (Roman roman : toRomanList(romanString)) {
            int current = roman.numeralValue;
            if (current <= last)
                last = current;
            else
                throw new IllegalArgumentException();
        }
    }

    private static void validateRomanOccurenceCorrect(String romanString) {
        if (!Roman.getAll().stream()
                .noneMatch(roman -> countRomanInString(romanString, roman) > 3))
            throw new IllegalArgumentException();
    }

    private static void validateSpecialCharsExistOnlyOnce(String romanString) {
        if (!Roman.getSpecialRomans().stream()
                .noneMatch(roman -> countRomanInString(romanString, roman) > 1))
            throw new IllegalArgumentException();
    }

    private static long countRomanInString(String romanString, Roman roman) {
        return toRomanList(romanString).stream()
                .filter(roman::equals)
                .count();
    }

    private static List<Roman> toRomanList(String roman) {
        return Stream.of(roman.split(PER_CHAR))
                .map(Roman::fromValue)
                .collect(Collectors.toList());
    }
}
