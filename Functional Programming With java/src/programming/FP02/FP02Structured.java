package programming.FP02;

import java.util.List;

public class FP02Structured {

    public static void main(String[] args) {

        List<Integer> numbersList = List.of(12, 34, 56, 68, 89, 12, 12, 23);
        System.out.println(addListStructured(numbersList));
    }

    private static int addListStructured(List<Integer> numbersList) {
        int sum = 0;
        for (int number : numbersList) {
            sum += number;
        }

        return sum;
    }


}
