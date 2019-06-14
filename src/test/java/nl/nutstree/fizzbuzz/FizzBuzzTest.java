package nl.nutstree.fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class FizzBuzzTest {

    @Test
    public void als15_FizzBuzz() {
        assertThat(FizzBuzz.convert(15)).isEqualTo("FizzBuzz");
    }

    @Test
    public void als90_FizzBuzz() {
        assertThat(FizzBuzz.convert(90)).isEqualTo("FizzBuzz");
    }

    @Test
    public void als5_Buzz() {
        assertThat(FizzBuzz.convert(5)).isEqualTo("Buzz");
    }

}

/**
 * #15 = FizzBuzz
 * 90 = FizzBuzz
 * #5 = Buzz
 * 3 = Fizz
 * 2 = 2
 * 32 = 32
 */
