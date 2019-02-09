package nl.nutstree.romannumerals.try20190208;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RomanNumeralsTest {

    @Test
    public void empty_0() {
        assertEquals(RomanNumerals.convert(""), 0);
    }

    @Test
    public void null_NullException() {
        assertThrows(NullPointerException.class, () -> RomanNumerals.convert(null));
    }

    @Test
    public void illegalRoman_illegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.convert("P"));
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.convert("R"));
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.convert("IP"));
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.convert("aa"));
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.convert("ii"));
    }

    @Test
    public void I_1() {
        assertEquals(RomanNumerals.convert("I"), 1);
    }

    @Test
    public void II_2() {
        assertEquals(RomanNumerals.convert("II"), 2);
    }

    @Test
    public void III_3() {
        assertEquals(RomanNumerals.convert("III"), 3);
    }

}
