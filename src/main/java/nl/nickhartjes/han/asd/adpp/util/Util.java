package nl.nickhartjes.han.asd.adpp.util;

public class Util {

    private Util() {
        throw new UnsupportedOperationException();
    }

    public static <E> String printArray(E[] inputArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (E element : inputArray) {
            stringBuilder.append(element.toString());
            stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }
}
