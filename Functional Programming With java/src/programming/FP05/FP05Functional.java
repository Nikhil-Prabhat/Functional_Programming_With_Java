package programming.FP05;

import programming.FP04.Course;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class FP05Functional {

    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        List<String> courses2 = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        // Join all the values with space
        // Spring Spring Boot API Microservices AWS PCF Azure Docker Kubernetes
        System.out.println(courses.stream().collect(Collectors.joining(" ")));

        // flatMap is used to map the multidimensional streams produced due to map
        // [S, p, r, i, n, g, S, p, r, i, n, g,  , B, o, o, t, A, P, I, M, i, c, r, o, s, e, r, v, i, c, e, s, A, W, S, P, C, F, A, z, u, r, e, D, o, c, k, e, r, K, u, b, e, r, n, e, t, e, s]
        System.out.println(courses.stream().map(course -> course.split("")).flatMap(Arrays::stream).collect(Collectors.toList()));

        // [Spring, Spring, Boot, API, Microservices, AWS, PCF, Azure, Docker, Kubernetes]
        System.out.println(courses.stream().map(course -> course.split(" ")).flatMap(Arrays::stream).collect(Collectors.toList()));

        System.out.println(
                courses.stream().flatMap(
                        course -> courses2.stream().map(course2 -> List.of(course, course2))
                ).collect(Collectors.toList())
        );

        // [[Spring, Spring], [Spring Boot, Spring Boot], [API, API], [Microservices, Microservices], [AWS, AWS], [PCF, PCF], [Azure, Azure], [Docker, Docker], [Kubernetes, Kubernetes]]
        System.out.println(
                courses.stream().flatMap(
                        course -> courses2.stream().map(course2 -> List.of(course, course2))
                )
                        .filter(list -> list.get(0).equals(list.get(1)))
                        .collect(Collectors.toList())
        );

        int cutOffReviewScore = 95;
        Predicate<Course> predicateCourseGreaterThan90 = getCoursePredicate(cutOffReviewScore);

        courses.stream()
                .peek(System.out::println)
                .filter(course -> course.length() > 10)
                .map(course -> course.toUpperCase())
                .peek(System.out::println)
                .collect(Collectors.toList());

        // Parallel Streams
        long time = System.currentTimeMillis();

        //1872
        //System.out.println(LongStream.range(0,1000000000).sum());

        //146
        System.out.println(LongStream.range(0,1000000000).parallel().sum());

        System.out.println(System.currentTimeMillis() - time);

    }

    // Higher Order Function - Function which returns function
    private static Predicate<Course> getCoursePredicate(int cutOffReviewScore) {
        return course -> course.getReviewScore() > cutOffReviewScore;
    }
}
