public class SubarraySum {
    public static int check(int[] arr) {
        int sum = 0, len = arr.length;
        while (len > 0) {
            for (int i = len; i < arr.length; i++) {
                int a = reduceArray(slice(arr, i - len, i));
                if (a > sum)
                    sum = a;
            }
            len--;
        }
        return sum;
    }

    public static int[] slice(int[] arr, int i1, int i2) {
        int[] newArray = new int[1 + i2 - i1];
        for (int i = i1, j = 0; i <= i2; i++) {
            newArray[j] = arr[i];
            j++;
        }
        return newArray;
    }

    public static int reduceArray(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] c = { -1, -2, 3, 4, 5 };
        System.out.println(check(c));
    }
}
