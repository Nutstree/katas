package nl.nutstree.chop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ChopTest {

    @Test
    public void emptyArray_emptyResult() {
        assertThat(Chopper.chop(new int[]{}, 1)).isEqualTo(-1);
    }

    @Test
    public void oneNumber_position0() {
        assertThat(Chopper.chop(new int[]{1}, 1)).isEqualTo(0);
    }

    @Test
    public void numberNotInArray_emptyResult() {
        assertThat(Chopper.chop(new int[]{5}, 1)).isEqualTo(-1);
    }


    @Test
    public void targetOnPosition1_position1() {
        assertThat(Chopper.chop(new int[]{1, 3}, 3)).isEqualTo(1);
    }

    @Test
    public void targetOnLastPosition_positionLast() {
        assertThat(Chopper.chop(new int[]{1, 3, 5}, 5)).isEqualTo(2);
    }
}
