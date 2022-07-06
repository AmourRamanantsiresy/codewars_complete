import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class TextAlignJustify {
    public static String justify(String text, int width) {
        /* format the text : level 1 */
        List<String> text2 = toListS(format1(text, width).split(" \n"));

        for (int j = 0; j < text2.size() - 1; j++) {
            List<String> text3 = toListS(text2.get(j).split(""));
            int len = text2.get(j).length();
            while (len != width && !text3.contains(" ")) {
                for (int i = 0; i < text3.size(); i++) {
                    if (len == width) {
                        break;
                    } else if (i < (text3.size() - 1) && text3.get(i).equals(" ") && !(text3.get(i + 1).equals(" "))) {
                        text3.add(i, " ");
                        len++;
                        i++;
                    }
                }
            }
            text2.set(j, String.join("", text3));
        }
        int len2 = text2.size() - 1, len3 = text2.get(len2).length() - 1;
        text2.set(len2, text2.get(len2).substring(0, len3));
        return String.join("\n", text2);
    }

    public static String format1(String text, int width) {
        StringBuffer a = new StringBuffer();
        String[] text2 = text.split(" ");
        int c = 0;
        for (String b : text2) {
            if (c + b.length() + 1 <= width) {
                a.append(b).append(" ");
                c += b.length() + 1;
            } else {
                c = b.length();
                a.append("\n").append(b).append(" ");
            }
        }
        return a.toString();
    }

    public static List<String> toListS(String[] arr) {
        List<String> res = new ArrayList<>();
        for (String b : arr) {
            res.add(b);
        }
        return res;
    }

    public static void main(String[] args) {
        String result = "Lorem  ipsum  dolor  sit amet,\n"
                + "consectetur  adipiscing  elit.\n"
                + "Vestibulum    sagittis   dolor\n"
                + "mauris,  at  elementum  ligula\n"
                + "tempor  eget.  In quis rhoncus\n"
                + "nunc,  at  aliquet orci. Fusce\n"
                + "at   dolor   sit   amet  felis\n"
                + "suscipit   tristique.   Nam  a\n"
                + "imperdiet   tellus.  Nulla  eu\n"
                + "vestibulum    urna.    Vivamus\n"
                + "tincidunt  suscipit  enim, nec\n"
                + "ultrices   nisi  volutpat  ac.\n"
                + "Maecenas   sit   amet  lacinia\n"
                + "arcu,  non dictum justo. Donec\n"
                + "sed  quam  vel  risus faucibus\n"
                + "euismod.  Suspendisse  rhoncus\n"
                + "rhoncus  felis  at  fermentum.\n"
                + "Donec lorem magna, ultricies a\n"
                + "nunc    sit    amet,   blandit\n"
                + "fringilla  nunc. In vestibulum\n"
                + "velit    ac    felis   rhoncus\n"
                + "pellentesque. Mauris at tellus\n"
                + "enim.  Aliquam eleifend tempus\n"
                + "dapibus. Pellentesque commodo,\n"
                + "nisi    sit   amet   hendrerit\n"
                + "fringilla,   ante  odio  porta\n"
                + "lacus,   ut   elementum  justo\n"
                + "nulla et dolor.";

        String test = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sa"
                + "gittis dolor mauris, at elementum ligula tempor eget. In quis rhoncus nunc, at aliquet orci. Fusc"
                + "e at dolor sit amet felis suscipit tristique. Nam a imperdiet tellus. Nulla eu vestibulum urna. V"
                + "ivamus tincidunt suscipit enim, nec ultrices nisi volutpat ac. Maecenas sit amet lacinia arcu, no";
        System.out.println(justify(test, 21));

    }

    public static Boolean compare(String un, String deux) {
        if (un.length() != deux.length()) {
            System.out.println("Les longueurs ne correspondent pas. length1 : " + un.length() + " et " + "length2 : "
                    + deux.length());
            return false;
        }
        String[] a = un.split(""), b = deux.split("");
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) {
                System.out.println(a[i] + " et " + b[i] + " ne sont pas les mêmes sur " + i);
                System.out.println(deux.substring(0, i));
                return false;
            }
        }
        return true;
    }
}
