import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfIntervals {
    public static int sumIntervals(int[][] intervals) {
        var xyz = Arrays.stream(intervals).sorted((a, b) -> a[1] - b[1]).toList();
        List<List<Integer>> intervalSorted = toList(xyz);
        show(intervalSorted);
        int j = 0;
        while (j != intervalSorted.size()) {
            j = intervalSorted.size();
            for (int i = 1; i < intervalSorted.size(); i++) {
                if (intervalSorted.get(i - 1).get(0) >= intervalSorted.get(i).get(0)) {
                    intervalSorted.remove(i - 1);
                } else if (intervalSorted.get(i - 1).get(1) >= intervalSorted.get(i).get(0)) {
                    intervalSorted.get(i).set(0, intervalSorted.get(i - 1).get(0));
                    intervalSorted.remove(i - 1);
                }
            }
        }
        show(intervalSorted);
        Integer sum = 0;
        for (List<Integer> i : intervalSorted) {
            sum += i.get(1) - i.get(0);
        }
        return sum;
    }

    public static List<List<Integer>> toList(List<int[]> arr) {
        List<List<Integer>> res = new ArrayList<>();
        for (int[] a : arr) {
            List<Integer> c = new ArrayList<>();
            c.add(a[0]);
            c.add(a[1]);
            res.add(c);
        }
        return res;
    }

    public static void show(List<List<Integer>> c) {
        StringBuffer res = new StringBuffer();
        for (List<Integer> i : c) {
            res.append("[ ").append(i.get(0)).append(", ").append(i.get(1)).append(" ], ");
        }
        System.out.println(res.substring(0, res.length() - 2).toString());
    }

    public static void main(String[] args) {
        int[][] test = { { -7, 8 }, { -2, 10 }, { 5, 15 }, { 2000, 3150 }, { -5400, -5338 } };
        int[][] test2 = { { 1, 5 }, { 10, 20 }, { 1, 6 }, { 16, 19 }, { 5, 11 } };
        System.out.println(sumIntervals(test2));
    }
}
