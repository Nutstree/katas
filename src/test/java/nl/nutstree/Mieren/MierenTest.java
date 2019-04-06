package nl.nutstree.Mieren;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MierenTest {

    @Test
    public void A_B_0_isAB() {
        Mieren mieren = new Mieren("A", "B");
        assertThat(mieren.tijdStap(0)).isEqualTo("AB");
    }

    @Test
    public void A_B_1_isBA() {
        Mieren mieren = new Mieren("A", "B");
        assertThat(mieren.tijdStap(1)).isEqualTo("BA");
    }

    @Test
    public void AB_C_1_isACB() {
        Mieren mieren = new Mieren("AB", "C");
        assertThat(mieren.tijdStap(1)).isEqualTo("ACB");
    }

    @Test
    public void AB_C_2_isCAB() {
        Mieren mieren = new Mieren("AB", "C");
        assertThat(mieren.tijdStap(2)).isEqualTo("CAB");
    }


    @Test
    public void AB_C_3_isCAB() {
        Mieren mieren = new Mieren("AB", "C");
        assertThat(mieren.tijdStap(2)).isEqualTo("CAB");
    }

    @Test
    public void AB_C_5_isCAB() {
        Mieren mieren = new Mieren("AB", "C");
        assertThat(mieren.tijdStap(2)).isEqualTo("CAB");
    }

    @Test
    public void ABCDE_FGH_3_isABFCGDHE() {
        Mieren mieren = new Mieren("ABCDE", "FGH");
        assertThat(mieren.tijdStap(3)).isEqualTo("ABFCGDHE");
    }

    @Test
    public void ABCDE_FGH_6_isFGAHBCDE() {
        Mieren mieren = new Mieren("ABCDE", "FGH");
        assertThat(mieren.tijdStap(6)).isEqualTo("FGAHBCDE");
    }
}
