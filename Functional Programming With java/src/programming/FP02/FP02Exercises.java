package programming.FP02;

import java.util.List;

public class FP02Exercises {

    public static void main(String[] args) {
        int sumOfSquares = squareEveryNumberAndFindTheSum(List.of(12, 23, 45, 56, 76, 23));
        System.out.println(sumOfSquares);

        int sumOfOddNumbers = findSumOfOddNumbers(List.of(12, 23, 45, 56, 76, 23));
        System.out.println(sumOfOddNumbers);
    }

    private static int findSumOfOddNumbers(List<Integer> numberList) {
        return numberList.stream()
                .filter(num -> num % 2 != 0)
                .reduce(0, Integer::sum);
    }

    private static int squareEveryNumberAndFindTheSum(List<Integer> numberList) {
        return numberList.stream()
                .map(num -> num * num)
                .reduce(0, Integer::sum);
    }


}
