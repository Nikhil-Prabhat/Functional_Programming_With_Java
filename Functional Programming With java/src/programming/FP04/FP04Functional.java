package programming.FP04;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP04Functional {

    public static void main(String[] args) {
        List<Course> courses = List.of(new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000)
        );

        Predicate<Course> predicateCourseGreaterThan90 = course -> course.getReviewScore() > 90;
        Predicate<Course> predicateCourseGreaterThan95 = course -> course.getReviewScore() > 95;

        // allMatch, noneMatch, anyMatch
        System.out.println(courses.stream().allMatch(predicateCourseGreaterThan90));
        System.out.println(courses.stream().noneMatch(predicateCourseGreaterThan95));
        System.out.println(courses.stream().anyMatch(predicateCourseGreaterThan90));

        // Comparator
        Comparator<Course> comparingByNoOfStudentsIncreasing = Comparator.comparing(Course::getNoOfStudents);
        Comparator<Course> comparingByNoOfStudentsDecreasing = Comparator.comparing(Course::getNoOfStudents).reversed();
        Comparator<Course> comparingByNoOfStudentsAndNoOfReviews = Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore).reversed();

        // [Course{name='FullStack', category='FullStack', reviewScore=91, noOfStudents=14000}, Course{name='Spring Boot', category='Framework', reviewScore=95, noOfStudents=18000}, Course{name='Spring', category='Framework', reviewScore=98, noOfStudents=20000}, Course{name='Docker', category='Cloud', reviewScore=92, noOfStudents=20000}, Course{name='Kubernetes', category='Cloud', reviewScore=91, noOfStudents=20000}, Course{name='AWS', category='Cloud', reviewScore=92, noOfStudents=21000}, Course{name='Azure', category='Cloud', reviewScore=99, noOfStudents=21000}, Course{name='API', category='Microservices', reviewScore=97, noOfStudents=22000}, Course{name='Microservices', category='Microservices', reviewScore=96, noOfStudents=25000}]
        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsIncreasing)
                        .collect(Collectors.toList())
        );

        // [Course{name='Microservices', category='Microservices', reviewScore=96, noOfStudents=25000}, Course{name='API', category='Microservices', reviewScore=97, noOfStudents=22000}, Course{name='AWS', category='Cloud', reviewScore=92, noOfStudents=21000}, Course{name='Azure', category='Cloud', reviewScore=99, noOfStudents=21000}, Course{name='Spring', category='Framework', reviewScore=98, noOfStudents=20000}, Course{name='Docker', category='Cloud', reviewScore=92, noOfStudents=20000}, Course{name='Kubernetes', category='Cloud', reviewScore=91, noOfStudents=20000}, Course{name='Spring Boot', category='Framework', reviewScore=95, noOfStudents=18000}, Course{name='FullStack', category='FullStack', reviewScore=91, noOfStudents=14000}]
        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsDecreasing)
                        .collect(Collectors.toList())
        );

        // [Course{name='FullStack', category='FullStack', reviewScore=91, noOfStudents=14000}, Course{name='Spring Boot', category='Framework', reviewScore=95, noOfStudents=18000}, Course{name='Kubernetes', category='Cloud', reviewScore=91, noOfStudents=20000}, Course{name='Docker', category='Cloud', reviewScore=92, noOfStudents=20000}, Course{name='Spring', category='Framework', reviewScore=98, noOfStudents=20000}, Course{name='AWS', category='Cloud', reviewScore=92, noOfStudents=21000}, Course{name='Azure', category='Cloud', reviewScore=99, noOfStudents=21000}, Course{name='API', category='Microservices', reviewScore=97, noOfStudents=22000}, Course{name='Microservices', category='Microservices', reviewScore=96, noOfStudents=25000}]
        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsAndNoOfReviews)
                        .collect(Collectors.toList())
        );

        // Pick only top 5
        // [Course{name='FullStack', category='FullStack', reviewScore=91, noOfStudents=14000}, Course{name='Spring Boot', category='Framework', reviewScore=95, noOfStudents=18000}, Course{name='Spring', category='Framework', reviewScore=98, noOfStudents=20000}, Course{name='Docker', category='Cloud', reviewScore=92, noOfStudents=20000}, Course{name='Kubernetes', category='Cloud', reviewScore=91, noOfStudents=20000}]
        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsIncreasing)
                        .limit(5)
                        .collect(Collectors.toList())
        );

        // Skip first 3
        // [Course{name='Docker', category='Cloud', reviewScore=92, noOfStudents=20000}, Course{name='Kubernetes', category='Cloud', reviewScore=91, noOfStudents=20000}, Course{name='AWS', category='Cloud', reviewScore=92, noOfStudents=21000}, Course{name='Azure', category='Cloud', reviewScore=99, noOfStudents=21000}, Course{name='API', category='Microservices', reviewScore=97, noOfStudents=22000}, Course{name='Microservices', category='Microservices', reviewScore=96, noOfStudents=25000}]
        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsIncreasing)
                        .skip(3)
                        .collect(Collectors.toList())
        );

        /* But the below condition will break as soon as it encounters the first non-matching condition */
        // [Course{name='Spring', category='Framework', reviewScore=98, noOfStudents=20000}, Course{name='Spring Boot', category='Framework', reviewScore=95, noOfStudents=18000}, Course{name='API', category='Microservices', reviewScore=97, noOfStudents=22000}, Course{name='Microservices', category='Microservices', reviewScore=96, noOfStudents=25000}, Course{name='FullStack', category='FullStack', reviewScore=91, noOfStudents=14000}, Course{name='AWS', category='Cloud', reviewScore=92, noOfStudents=21000}, Course{name='Azure', category='Cloud', reviewScore=99, noOfStudents=21000}, Course{name='Docker', category='Cloud', reviewScore=92, noOfStudents=20000}, Course{name='Kubernetes', category='Cloud', reviewScore=91, noOfStudents=20000}]
        // It will print as long as the condition is true
        System.out.println(
                courses.stream()
                        .takeWhile(course -> course.getNoOfStudents() > 95)
                        .collect(Collectors.toList())
        );

        // [Course{name='Spring', category='Framework', reviewScore=98, noOfStudents=20000}, Course{name='Spring Boot', category='Framework', reviewScore=95, noOfStudents=18000}, Course{name='API', category='Microservices', reviewScore=97, noOfStudents=22000}, Course{name='Microservices', category='Microservices', reviewScore=96, noOfStudents=25000}, Course{name='FullStack', category='FullStack', reviewScore=91, noOfStudents=14000}, Course{name='AWS', category='Cloud', reviewScore=92, noOfStudents=21000}, Course{name='Azure', category='Cloud', reviewScore=99, noOfStudents=21000}, Course{name='Docker', category='Cloud', reviewScore=92, noOfStudents=20000}, Course{name='Kubernetes', category='Cloud', reviewScore=91, noOfStudents=20000}]
        System.out.println(
                courses.stream()
                        .dropWhile(course -> course.getReviewScore() > 98)
                        .collect(Collectors.toList())
        );

        // Optional[Course{name='Microservices', category='Microservices', reviewScore=96, noOfStudents=25000}]
        // Max will always print the last element
        // Min will return the first element
        System.out.println(
                courses.stream()
                        .max(comparingByNoOfStudentsAndNoOfReviews)
        );

        // 88000
        System.out.println(
                courses.stream()
                        .filter(predicateCourseGreaterThan95)
                        .mapToInt(Course::getNoOfStudents)
                        .sum()
        );

        // 22000.0
        System.out.println(
                courses.stream()
                        .filter(predicateCourseGreaterThan95)
                        .mapToInt(Course::getNoOfStudents)
                        .average()
        );

        // 4
        System.out.println(
                courses.stream()
                        .filter(predicateCourseGreaterThan95)
                        .mapToInt(Course::getNoOfStudents)
                        .count()
        );

        // Creating a map of objects

        // {Cloud=[Course{name='AWS', category='Cloud', reviewScore=92, noOfStudents=21000}, Course{name='Azure', category='Cloud', reviewScore=99, noOfStudents=21000}, Course{name='Docker', category='Cloud', reviewScore=92, noOfStudents=20000}, Course{name='Kubernetes', category='Cloud', reviewScore=91, noOfStudents=20000}], FullStack=[Course{name='FullStack', category='FullStack', reviewScore=91, noOfStudents=14000}], Microservices=[Course{name='API', category='Microservices', reviewScore=97, noOfStudents=22000}, Course{name='Microservices', category='Microservices', reviewScore=96, noOfStudents=25000}], Framework=[Course{name='Spring', category='Framework', reviewScore=98, noOfStudents=20000}, Course{name='Spring Boot', category='Framework', reviewScore=95, noOfStudents=18000}]}
        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory))
        );

        // Finding the count of the courses
        // {Cloud=4, FullStack=1, Microservices=2, Framework=2}
        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()))
        );

        // {Cloud=Optional[Course{name='Azure', category='Cloud', reviewScore=99, noOfStudents=21000}], FullStack=Optional[Course{name='FullStack', category='FullStack', reviewScore=91, noOfStudents=14000}], Microservices=Optional[Course{name='API', category='Microservices', reviewScore=97, noOfStudents=22000}], Framework=Optional[Course{name='Spring', category='Framework', reviewScore=98, noOfStudents=20000}]}
        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory, Collectors.maxBy(Comparator.comparing(Course::getReviewScore))))
        );

        // {Cloud=[AWS, Azure, Docker, Kubernetes], FullStack=[FullStack], Microservices=[API, Microservices], Framework=[Spring, Spring Boot]}
        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory, Collectors.mapping(Course::getName, Collectors.toList())))
        );

    }
}
