package algorithms.tree;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
 * <p>
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 *
 * @author fuzf
 */
public class BalancedBinaryTreeMain {

    //    public static boolean isBalanced(TreeNode root) {
//
//    }
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
