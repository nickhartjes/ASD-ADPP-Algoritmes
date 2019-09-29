package nl.nickhartjes.han.asd.adpp;

import nl.nickhartjes.han.asd.adpp.models.Student;
import nl.nickhartjes.han.asd.adpp.sort.InsertionSort;
import nl.nickhartjes.han.asd.adpp.sort.MergeSort;
import nl.nickhartjes.han.asd.adpp.sort.QuickSort;
import nl.nickhartjes.han.asd.adpp.util.Util;

class Main {

    public static void main(String... args) {
        int[] array01 = {12, 123, 123, 334, 52, 1, 13, 655, 66};
        int[] array02 = {21, 9, 75, 77, 48, 12, 91, 73, 84, 57, 97, 23, 9, 94, 91, 80, 4, 46, 73, 92, 22, 91, 84, 40, 6, 61, 64, 90, 42, 6, 72, 54, 54, 30, 79, 3, 78, 88, 54, 22, 16, 70, 18, 15, 45, 33, 23, 81, 71, 2, 55, 86, 37, 97, 76, 41, 54, 29, 28, 34, 36, 100, 77, 94, 91, 41, 91, 16, 65, 34, 97, 32, 75, 76, 73, 79, 39, 78, 92, 60, 64, 50, 65, 93, 64, 65, 66, 13, 33, 22, 55, 10, 51, 31, 29, 96, 11, 21, 23, 43};
        Character[] array03 = {'L', 'f', 'e', 'C', 'f', 'J', 'L', 'z', 'X', 's', 'Z', 'V', 'Z', 'E', 'd', 'X', 'f', 'H', 'P', 'y', 'V', 'f', 'd', 'M', 'o', 'V', 'p', 'o', 'S', 'k', 'g', 'u', 'J', 'P', 'k', 'f', 'c', 'G', 'i', 'f'};

        var marc = new Student(527698, "Marc", "Groenhout");
        var joey = new Student(609589, "Joey", "Stoffels");
        var nick = new Student(423064, "Nick", "Hartjes");
        Student[] array04 = {marc, joey, nick};

        var runInsertion = new InsertionSort();
        Util.printArray(runInsertion.sort(array01));
        Util.printArray(runInsertion.sort(array02));

        var runMerge = new MergeSort();
        Util.printArray(runMerge.sort(array01));
        Util.printArray(runMerge.sort(array02));

        var quickMerge = new QuickSort();
        Util.printArray(quickMerge.sort(array01));
        Util.printArray(quickMerge.sort(array02));

        Util.printArray(quickMerge.sort(array01, true));
        Util.printArray(quickMerge.sort(array02, true));

        var quickMergeCharacter = new nl.nickhartjes.han.asd.adpp.sort.generic.QuickSort<Character>();
        Util.printArray(quickMergeCharacter.sort(array03, true));

        var quickMergeStudent = new nl.nickhartjes.han.asd.adpp.sort.generic.QuickSort<Student>();
        Util.printArray(quickMergeStudent.sort(array04, true));
    }
}
