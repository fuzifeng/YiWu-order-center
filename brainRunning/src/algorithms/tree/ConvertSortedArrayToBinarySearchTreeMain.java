package algorithms.tree;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fuzf
 */
public class ConvertSortedArrayToBinarySearchTreeMain {

    public static TreeNode solution(int[] nums) {
        return subTree(0, nums.length - 1, nums);
    }

    public static TreeNode subTree(int leftIndex, int rightIndex, int[] nums) {
        if (leftIndex > rightIndex) {
            return null;
        }
        int mid = (rightIndex - leftIndex) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = subTree(leftIndex, mid - 1, nums);
        treeNode.right = subTree(mid + 1, rightIndex, nums);
        return treeNode;
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}
