package algorithms.tree;

/**
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * 示例 1：
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 *
 * 示例 2：
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 *
 * 示例 3：
 * 输入：root = [1,2], targetSum = 0
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fuzf
 */
public class PathSumMain {

    public static void main(String[] args) {

    }

    public static boolean exist(TreeNode root, int target) {
        if (root == null || target < 0) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == target) {
            return true;
        }
        target = target - root.val;
        return exist(root.left, target) || exist(root.right, target);
    }

}
