import java.util.ArrayList;
import java.util.List;

public class Permutation {
    static List<String> result = new ArrayList<>();

    public static void permute(String now, List<String> b) {
        if (b.size() == 1 && !result.contains(now + b.get(0))) {
            result.add(now + b.get(0));
        } else {
            for (int i = 0; i < b.size(); i++) {
                List<String> d = copy(b);
                d.remove(i);
                permute(now + b.get(i), d);
            }
        }
    }

    public static List<String> copy(List<String> a) {
        List<String> b = new ArrayList<>();
        for (String c : a) {
            b.add(c);
        }
        return b;
    }

    public static List<String> stringToList(String a) {
        String[] b = a.split("");
        List<String> res = new ArrayList<>();
        for (String c : b) {
            res.add(c);
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> test = stringToList("abcd");
        permute("", test);
        System.out.println(result);
    }

}