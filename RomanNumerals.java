import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RomanNumerals {
    public static String toRoman(int a) {
        String[] b = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X" };
        if (a == 0) {
            return "";
        } else if (a >= 1000) {
            return "M" + toRoman(a - 1000);
        } else if (a >= 900) {
            return "CM" + toRoman(a - 900);
        } else if (a >= 500) {
            return "D" + toRoman(a - 500);
        } else if (a >= 400) {
            return "CD" + toRoman(a - 400);
        } else if (a >= 100) {
            return "C" + toRoman(a - 100);
        } else if (a >= 97) {
            return b[99 - a] + "C";
        } else if (a >= 90) {
            return "XC" + toRoman(a - 90);
        } else if (a >= 50) {
            return "L" + toRoman(a - 50);
        } else if (a >= 47) {
            return b[49 - a] + "XL";
        } else if (a >= 40) {
            return "XL" + toRoman(a - 40);
        } else if (a >= 10) {
            return "X" + toRoman(a - 10);
        }
        return b[a - 1];
    }

    public static int fromRoman(String romanNumeral) {
        HashMap<String, Integer> datas = data();
        String[] rom = romanNumeral.split("");
        List<Integer> roma = new ArrayList<>();
        int j = 0;
        for (String i : rom) {
            roma.add(datas.get(i));
        }
        while (j != roma.size()) {
            j = roma.size();
            for (int i = 1; i < roma.size(); i++) {
                if (roma.get(i) > roma.get(i - 1)) {
                    roma.set(i, roma.get(i) - roma.get(i - 1));
                    roma.remove(i - 1);
                }
            }
        }
        return reduce(roma);
    }

    public static int reduce(List<Integer> a) {
        int acc = 0;
        for (Integer c : a) {
            acc += c;
        }
        return acc;
    }

    public static HashMap<String, Integer> data() {
        HashMap<String, Integer> res = new HashMap<>();
        res.put("I", 1);
        res.put("V", 5);
        res.put("X", 10);
        res.put("L", 50);
        res.put("C", 100);
        res.put("D", 500);
        res.put("M", 1000);
        return res;
    }

    public static void main(String[] args) {
        StringBuffer res = new StringBuffer();
        /*
         * for (int a = 1; a < 40; a++) {
         * res.append(toRoman(a)).append("->");
         * }
         * System.out.println(res.substring(0, res.length() - 2).toString());
         */
        System.out.println(toRoman(44));
    }
}
