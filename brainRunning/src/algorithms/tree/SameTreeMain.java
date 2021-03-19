package algorithms.tree;

public class SameTreeMain {

    public static boolean sameField(TreeNode tree1, TreeNode tree2) {
        if (tree1 != null && tree2 != null) {
            if (tree1.val == tree2.val) {
                return sameField(tree1.left, tree2.left) && sameField(tree1.right, tree2.right);
            } else {
                return false;
            }
        } else if ((tree1 != null && tree2 == null) || (tree1 == null && tree2 != null)) {
            return false;
        } else {
            return true;
        }
    }
}
