package nl.nickhartjes.han.asd.adpp.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Util {

    private static final Logger logger = LoggerFactory.getLogger(Util.class);

    private Util() {
        throw new UnsupportedOperationException();
    }

    @SuppressWarnings("squid:S106")
    public static void printArray(int[] array) {
        logger.info(Arrays.toString(array));
    }

    @SuppressWarnings("squid:S106")
    public static <E> void printArray(E[] inputArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (E element : inputArray)
            stringBuilder.append(element.toString());
        logger.info(stringBuilder.toString());
    }
}
