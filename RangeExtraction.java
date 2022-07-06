public class RangeExtraction {

    public static String rangeExtraction(int[] arr) {
        StringBuffer res = new StringBuffer();
        for (int i = 0, b = 0, c = 0; i < (arr.length - 1); i++) {
            System.out.println(arr[i] + " " + arr[i + 1] + " " + i);
            if (Math.abs(arr[i] - arr[i + 1]) == 1) {
                b++;
            } else if (b < 2) {
                res.append(c != arr[i] ? "," : "").append(c != arr[i] ? arr[i] : "").append(",").append(arr[i + 1]);
                c = arr[i + 1];
                b = 0;
            } else {
                res.append("-").append(arr[i]).append(",").append(arr[i + 1]);
                c = arr[i + 1];
                b = 0;
            }
            if (i == arr.length - 2) {
                if (b == 0) {
                    res.append(",").append(arr[i + 1]);
                } else {
                    res.append("-").append(arr[i + 1]);
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int[] arr = new int[] { -3, -2, -1, 2, 10, 15, 16, 18, 19, 20 };
        System.out.println(rangeExtraction(arr));
    }
}