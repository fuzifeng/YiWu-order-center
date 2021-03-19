package algorithms.tree;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * https://leetcode-cn.com/problems/symmetric-tree/
 *
 * @author fuzf
 */
public class SymmetricTreeMain {

    public static boolean solution(TreeNode tree) {
        return false;
    }

    public static boolean symmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null) {
            if (left.val == right.val) {
                return symmetric(left.left, right.right) && symmetric(left.right, right.left);
            }
            return false;
        }
        return false;
    }
}
