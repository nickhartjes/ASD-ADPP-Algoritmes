package nl.nickhartjes.han.asd.adpp.util;

import java.util.Arrays;

public class Util {
    private Util() {
        throw new UnsupportedOperationException();
    }

    @SuppressWarnings("squid:S106")
    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    @SuppressWarnings("squid:S106")
    public static <E> void printArray(E[] inputArray) {
        for (E element : inputArray)
            System.out.printf("%s ", element);

        System.out.println();
    }
}
