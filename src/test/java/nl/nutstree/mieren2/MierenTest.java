package nl.nutstree.mieren2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MierenTest {

    @Test
    public void startPositie() {
        Mieren mieren = new Mieren("A", "B");
        assertThat(mieren.stappen(0)).isEqualTo("AB");
    }

    @Test
    public void A_B_na1stap_AB() {
        Mieren mieren = new Mieren("A", "B");
        assertThat(mieren.stappen(1)).isEqualTo("BA");
    }

    @Test
    public void BA_C_na1stap_BCAD() {
        Mieren mieren = new Mieren("BA", "C");
        assertThat(mieren.stappen(1)).isEqualTo("BCA");
    }
}
