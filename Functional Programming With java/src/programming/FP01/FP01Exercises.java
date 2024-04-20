package programming.FP01;

import java.util.List;

public class FP01Exercises {

    public static void main(String[] args) {
        printOnlyOddNumbersInList(List.of(12, 23, 45, 56, 76, 23));
        printAllCoursesIndividually(List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes"));
        printCoursesContainingWordsSpring(List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes"));
        printCoursesWhoseNameHasAtLeastFourLetters(List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes"));
        printCubesOfOddNumbers(List.of(12, 23, 45, 56, 76, 23));
        printNumberOfCharactersInEachCourseName(List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes"));
    }

    private static void printNumberOfCharactersInEachCourseName(List<String> courseNames) {
        courseNames.stream()
                .map(course -> course.length())
                .forEach(System.out::println);
    }

    private static void printCubesOfOddNumbers(List<Integer> numberList) {
        numberList.stream()
                .filter(number -> number % 2 != 0)
                .map(number -> (int) Math.pow(number, 3))
                .forEach(System.out::println);
    }

    private static void printCoursesWhoseNameHasAtLeastFourLetters(List<String> coursesList) {
        coursesList.stream()
                .filter(course -> course.length() >= 4)
                .forEach(System.out::println);
    }

    private static void printCoursesContainingWordsSpring(List<String> coursesList) {
        coursesList.stream()
                .filter(course -> course.contains("Spring"))
                .forEach(System.out::println);
    }

    private static void printAllCoursesIndividually(List<String> coursesList) {
        coursesList.stream()
                .forEach(System.out::println);
    }

    private static void printOnlyOddNumbersInList(List<Integer> numberList) {
        numberList.stream()
                .filter(number -> number % 2 != 0)
                .forEach(System.out::println);
    }
}
