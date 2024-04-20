package programming.FP01;

import java.util.List;

public class FP01Structured {

    public static void main(String[] args) {

        //printAllNumbersInListStructured(List.of(12, 34, 56, 68, 89, 12, 12, 23));
        printAllEvenNumbersInListStructured(List.of(12, 34, 56, 68, 89, 12, 12, 23));
    }

    // How to loop the numbers - Structured Approach
    private static void printAllNumbersInListStructured(List<Integer> numbersList) {
        for (Integer number : numbersList) {
            System.out.println(number);
        }
    }

    private static void printAllEvenNumbersInListStructured(List<Integer> numbersList) {
        for (Integer number : numbersList) {
            if (number % 2 == 0)
                System.out.println(number);
        }
    }
}
