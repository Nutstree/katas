package nl.nutstree.romannumerals.try20190302;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RomanNumeralsTest {

    @Test
    public void testAdditions() {
        assertThat(RomanNumerals.arabicToRoman(2)).isEqualTo("II");
        assertThat(RomanNumerals.arabicToRoman(3)).isEqualTo("III");
        assertThat(RomanNumerals.arabicToRoman(5)).isEqualTo("V");
        assertThat(RomanNumerals.arabicToRoman(7)).isEqualTo("VII");
        assertThat(RomanNumerals.arabicToRoman(13)).isEqualTo("XIII");
        assertThat(RomanNumerals.arabicToRoman(33)).isEqualTo("XXXIII");
        assertThat(RomanNumerals.arabicToRoman(87)).isEqualTo("LXXXVII");
        assertThat(RomanNumerals.arabicToRoman(200)).isEqualTo("CC");
    }

    @Test
    public void testAdditions_romanToArabic() {
        assertThat(RomanNumerals.romanToArabic("II")).isEqualTo(2);
        assertThat(RomanNumerals.romanToArabic("III")).isEqualTo(3);
        assertThat(RomanNumerals.romanToArabic("V")).isEqualTo(5);
        assertThat(RomanNumerals.romanToArabic("VII")).isEqualTo(7);
        assertThat(RomanNumerals.romanToArabic("XIII")).isEqualTo(13);
        assertThat(RomanNumerals.romanToArabic("XXXIII")).isEqualTo(33);
        assertThat(RomanNumerals.romanToArabic("LXXXVII")).isEqualTo(87);
        assertThat(RomanNumerals.romanToArabic("CC")).isEqualTo(200);
    }

    @Test
    public void testSubtractions() {
        assertThat(RomanNumerals.arabicToRoman(4)).isEqualTo("IV");
        assertThat(RomanNumerals.arabicToRoman(9)).isEqualTo("IX");
        assertThat(RomanNumerals.arabicToRoman(14)).isEqualTo("XIV");
        assertThat(RomanNumerals.arabicToRoman(29)).isEqualTo("XXIX");
        assertThat(RomanNumerals.arabicToRoman(40)).isEqualTo("XL");
        assertThat(RomanNumerals.arabicToRoman(49)).isEqualTo("XLIX");
        assertThat(RomanNumerals.arabicToRoman(99)).isEqualTo("XCIX");
    }


    @Test
    public void testSubtractions_romanToArabic() {
        assertThat(RomanNumerals.romanToArabic("IV")).isEqualTo(4);
        assertThat(RomanNumerals.romanToArabic("IX")).isEqualTo(9);
        assertThat(RomanNumerals.romanToArabic("XIV")).isEqualTo(14);
        assertThat(RomanNumerals.romanToArabic("XXIX")).isEqualTo(29);
        assertThat(RomanNumerals.romanToArabic("XL")).isEqualTo(40);
        assertThat(RomanNumerals.romanToArabic("XLIX")).isEqualTo(49);
        assertThat(RomanNumerals.romanToArabic("XCIX")).isEqualTo(99);
    }

    @Test
    public void illegalRoman_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.romanToArabic("IIII"));
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.romanToArabic("IIX"));
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.romanToArabic("LOL"));
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.romanToArabic("&^%"));
    }

    @Test
    public void illegalArabic_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.arabicToRoman(0));
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.arabicToRoman(-1));
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.arabicToRoman(-99));
    }

    @Test
    public void testSymmetrie() {
        IntStream.rangeClosed(1, 300)
                .forEach(RomanNumeralsTest::assertSymmetrie);
    }

    private static void assertSymmetrie(int input) {
        String roman = RomanNumerals.arabicToRoman(input);
        assertEquals(input, RomanNumerals.romanToArabic(roman));
    }
}
