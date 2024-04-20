package programming.FP02;

import java.util.Comparator;
import java.util.List;

public class FP02Functional {

    public static void main(String[] args) {
        List<Integer> numbersList = List.of(12, 34, 56, 68, 89, 12, 12, 23);
        List<String> coursesList = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        System.out.println(addListFunctional(numbersList));

        //Printing distinct numbers
        System.out.println("Distinct Numbers");
        numbersList.stream().distinct().forEach(System.out::println);

        //Printing sorted list
        System.out.println("Sorted Numbers");
        numbersList.stream().sorted().forEach(System.out::println);

        //Printing distinct sorted list
        System.out.println("Distict Sorted Numbers");
        numbersList.stream().distinct().sorted().forEach(System.out::println);

        // Printing sorted Courses
        System.out.println("Printing sorted courses");
        coursesList.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);

        // Printing sorted Courses in reverse order
        System.out.println("Printing sorted courses in reverse order");
        coursesList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        // Printing sorted courses as per length
        System.out.println("Printing sorted courses as per length");
        coursesList.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);
    }

    private static int addListFunctional(List<Integer> numbersList) {
        return numbersList.stream()
                .reduce(0, (x,y) -> x + y); // lambda function
                //.reduce(0, FP02Functional::getSumOfTwoNumbers);

    }

    private static int getSumOfTwoNumbers(int a, int b) {
        return a + b;
    }
}
