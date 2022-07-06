import java.util.ArrayList;
import java.util.List;

public class MinSum {
    public static int min(int[] arr) {
        List<Integer> newArr = new ArrayList<>();
        for (int i : arr) {
            newArr.add(i);
        }
        newArr = newArr.stream().sorted((a, b) -> a - b).toList();
        int sum = 0;
        for (int i = 0; i <= newArr.size() / 2; i++) {
            sum += newArr.get(i) * newArr.get(newArr.size() - 1 - i);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(min(arr));
    }
}
