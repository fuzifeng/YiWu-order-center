package algorithms.number;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fuzf
 */
public class ThreeNumsClosetMain {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-3,-2,-5,3,-4},-1));
    }


    public static int threeSumClosest(int[] nums, int target) {
        Integer result = null;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i;

            int zhong = i + 1;


            for (; zhong < nums.length - 1; zhong++) {
                if (zhong != i + 1 && nums[zhong] == nums[zhong - 1]) {
                    continue;
                }
                for (int right = nums.length - 1; right > zhong; right--) {
                    if (nums[left] + nums[zhong] + nums[right] == target) {
                        return target;
                    }
                    if (result == null) {
                        result = nums[left] + nums[zhong] + nums[right];
                        continue;
                    }
                    if (Math.abs(target - result) > Math.abs(target - (nums[left] + nums[zhong] + nums[right]))) {
                        result = nums[left] + nums[zhong] + nums[right];
                    }
                }
            }


        }
        return result;
    }
}
