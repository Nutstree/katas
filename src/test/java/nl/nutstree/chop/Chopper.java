package nl.nutstree.chop;

import java.util.Arrays;

public class Chopper {
    public static int chop(int[] input, int target) {
        int position = getMiddlePositionOfArray(input);

        if (position == -1 || input[position] == target)
            return position;

        if (input[position] > target)
            return chop(Arrays.copyOfRange(input, 0, position), target) + input.length / 2;

        return chop(Arrays.copyOfRange(input, position, input.length + 1), target) + input.length / 2;

    }

    private static int getMiddlePositionOfArray(int[] input) {
        return input.length != 0 ? input.length / 2 : -1;
    }
}
