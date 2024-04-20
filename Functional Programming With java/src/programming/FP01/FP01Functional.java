package programming.FP01;

import java.util.List;

public class FP01Functional {

    public static void main(String[] args) {
        //printAllNumbersInListFunctional(List.of(12, 34, 56, 68, 89, 12, 12, 23));
        printAllEvenNumbersInListFunctional(List.of(12, 34, 56, 68, 89, 12, 12, 23));
    }

    // What to do
    // Converting it into streams
    private static void printAllNumbersInListFunctional(List<Integer> numbersList) {

        // We are using method reference here
        numbersList.stream()
                //.forEach(FP01Functional::print);
                .forEach(System.out::println);
    }

    private static void printAllEvenNumbersInListFunctional(List<Integer> numbersList) {

        // We are using method reference here
        numbersList.stream()
                //.filter(FP01Functional::isEven) // Filter only even numbers with method reference
                .filter(number -> number % 2 == 0) // lambda function
                .forEach(System.out::println);
    }

    private static void print(Integer number) {
        System.out.println(number);
    }

    private static boolean isEven(Integer number) {
        return number % 2 == 0;
    }
}
