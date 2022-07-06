import java.util.ArrayList;

public class Snail {

    public static void main(String[] args) {
        int[][] array = {
                { 1, 2, 3, 4, 5 },
                { 7, 8, 9, 1, 6 },
                { 6, 6, 7, 2, 7 },
                { 5, 5, 4, 3, 8 },
                { 4, 3, 2, 1, 9 }
        };
        int[] res = snail(array);
        show(res);
    }

    public static int[] snail(int[][] arr) {
        int x = 0, y = 0, reduce = arr.length, count = 0, xy = 1, ad = 1, length = arr.length * arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        while (length > count) {
            if (ad == 1) {
                for (int i = (xy == 1 ? x : y); i < reduce; i++) {
                    if (xy == 1) {
                        x = i;
                    } else {
                        y = i;
                    }
                    result.add(arr[y][x]);
                    count++;
                }
                if (xy == 1) {
                    y++;
                } else {
                    x--;
                    ad *= -1;
                }
            } else {
                for (int i = (xy == 1 ? x : y); i >= arr.length - reduce; i--) {
                    if (xy == 1) {
                        x = i;
                    } else {
                        y = i;
                    }
                    result.add(arr[y][x]);
                    count++;
                }
                if (xy == 1) {
                    reduce--;
                    y--;
                } else {
                    x++;
                    ad *= -1;
                }
            }
            xy *= -1;
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void show(int arr[]) {
        StringBuffer res = new StringBuffer();
        for (int i : arr) {
            res.append(i).append(" -> ");
        }
        System.out.println(res.substring(0, res.length() - 4).toString());
    }
}
