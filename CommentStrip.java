import java.util.ArrayList;
import java.util.List;

public class CommentStrip {
    public static String stripComments(String t, String[] commentSymbols) {
        List<String> text = toList(t.split("\n"));
        List<String> symbol = toList(commentSymbols);
        for (int i = 0; i < text.size(); i++) {
            String[] txt = text.get(i).split("");
            for (int j = 0; j < txt.length; j++) {
                if (symbol.contains(txt[j])) {
                    text.set(i, text.get(i).substring(0, j));
                    break;
                }
            }
        }
        return String.join("\n", text);
    }

    public static List<String> toList(String[] arr) {
        List<String> res = new ArrayList<>();
        for (String a : arr) {
            res.add(a);
        }
        return res;
    }

    public static void main(String[] args) {
        String text = "apples, pears # and bananas"
                + "\ngrapes"
                + "\nbananas !apples";
        System.out.println(stripComments(text, new String[] { "#", "!" }));
    }
}
