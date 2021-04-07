package algorithms.tree;

/**
 * @Author: fuzf
 * @Date: 2021/3/30 21:36
 */
public class BalancedBinaryTreeMain {

    public static int height_from_di(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height_from_di(root.left);
        int rightHeight = height_from_di(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
