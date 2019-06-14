package nl.nutstree.fizzbuzz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FizzBuzz {

    private static Map<Integer, String> mapping = new HashMap<>();
    private static List<Mapping> mappingList = Arrays.asList(
            new FizzBuzzM(15, "FizzBuzz"),
            new FizzBuzzM(5, "Buzz")
    );

    static {
        mapping.put(90, "FizzBuzz");
        mapping.put(15, "FizzBuzz");
        mapping.put(5, "Buzz");
    }

    public static String convert(int input) {
        int mappingCounter = 0;
        String result = null;
        Mapping mapping = null;
        while (mappingCounter < mappingList.size() || result == null) {
            mapping = mappingList.get(mappingCounter++);
        }

        return null; //return mapping.get(input);
    }

    interface Mapping {

        Integer getOriginal();

        String conversion(int input);
    }

    private static class FizzBuzzM implements Mapping {

        private final int number;
        private final String mapping;

        public FizzBuzzM(int number, String mapping) {
            this.number = number;
            this.mapping = mapping;
        }

        @Override
        public Integer getOriginal() {
            return number;
        }

        @Override
        public String conversion(int input) {
            return mapping;
        }
    }


}
