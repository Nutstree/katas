package nl.nutstree.romannumerals.try20190208;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RomanNumeralsTest {

    @Test
    public void null_NullException() {
        assertThrows(NullPointerException.class, () -> RomanNumerals.convert(null));
    }

    @Test
    public void illegalRoman_illegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.convert(""));
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.convert("P"));
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.convert("R"));
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.convert("IP"));
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.convert("aa"));
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.convert("ii"));
    }

    @Test
    public void singleRoman() {
        assertEquals(RomanNumerals.convert("I"), 1);
        assertEquals(RomanNumerals.convert("V"), 5);
        assertEquals(RomanNumerals.convert("X"), 10);
        assertEquals(RomanNumerals.convert("L"), 50);
        assertEquals(RomanNumerals.convert("C"), 100);
        assertEquals(RomanNumerals.convert("D"), 500);
        assertEquals(RomanNumerals.convert("M"), 1000);
    }

    @Test
    public void multipleSameRoman() {
        assertEquals(RomanNumerals.convert("II"), 2);
        assertEquals(RomanNumerals.convert("III"), 3);
        assertEquals(RomanNumerals.convert("XX"), 20);
        assertEquals(RomanNumerals.convert("XXX"), 30);
        assertEquals(RomanNumerals.convert("CC"), 200);
        assertEquals(RomanNumerals.convert("CCC"), 300);
        assertEquals(RomanNumerals.convert("MM"), 2000);
        assertEquals(RomanNumerals.convert("MMM"), 3000);
    }

    @Test
    public void multipleSpecialRomans_illegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.convert("VV"));
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.convert("VVV"));
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.convert("LL"));
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.convert("LLL"));
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.convert("DD"));
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.convert("DDD"));
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.convert("IDD"));
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.convert("VVX"));
    }

    @Test
    public void multipleRomansWhoAddUp() {
        assertEquals(RomanNumerals.convert("VI"), 6);
        assertEquals(RomanNumerals.convert("XVII"), 17);
        assertEquals(RomanNumerals.convert("LXVIII"), 68);
        assertEquals(RomanNumerals.convert("CLXVII"), 167);
        assertEquals(RomanNumerals.convert("DCLXVI"), 666);
        assertEquals(RomanNumerals.convert("MMDCCLXXVII"), 2777);
    }

    @Test
    public void tooMuchRomans_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.convert("IIII"));
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.convert("XXXX"));
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.convert("CCCC"));
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.convert("MMMM"));
    }

    @Test
    public void romansNotCorrectlyOrdered_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.convert("IVII"));
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.convert("IXCXI"));
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.convert("MCXIM"));
        assertThrows(IllegalArgumentException.class, () -> RomanNumerals.convert("CCM"));
    }

    @Test
    public void substractRomanValue() {
        //assertEquals(4, RomanNumerals.convert("IV"));
    }
}
