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
}
