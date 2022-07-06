import java.util.List;
import java.util.ArrayList;

public class BinaryTree {
    static List<List<Integer>> res;
    static List<Integer> result;

    public static List<Integer> treeByLevels(Node node) {
        res = new ArrayList<>();
        result = new ArrayList<>();
        tree(node, 0);
        for (List<Integer> b : res) {
            for (Integer c : b) {
                result.add(c);
            }
        }
        return result;
    }

    public static void tree(Node node, int branchNum) {
        if (res.size() == branchNum) {
            List<Integer> temp = new ArrayList<>();
            temp.add(node.value);
            res.add(temp);
        } else {
            res.get(branchNum).add(node.value);
        }
        if (node.left != null) {
            tree(node.left, branchNum + 1);
        }
        if (node.right != null) {
            tree(node.right, branchNum + 1);
        }
    }
}
