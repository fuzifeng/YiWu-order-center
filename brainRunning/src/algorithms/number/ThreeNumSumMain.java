package algorithms.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author fuzf
 */
public class ThreeNumSumMain {

    public static void main(String[] args) {
        List<List<Integer>> solution = solution(new int[]{-4,-1,-1,0,1,2});
        solution.stream().forEach(v->{
            v.stream().forEach(val -> System.out.print(val + ","));
            System.out.println();
        });
    }

    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int left = 0;
        while (left < nums.length - 2 && nums[left] <= 0) {
            int leftNum = nums[left];
            if (left != 0 && leftNum == nums[left - 1]) {
                left++;
                continue;
            }
            int right = nums.length - 1;
            int zhong = left + 1;
            int rightNum = nums[right];
            int zhongNum = nums[zhong];

            for (; zhong < nums.length - 1; zhong++) {
                if (nums[zhong] == nums[zhong - 1] && zhong != left + 1) {
                    continue;
                }
                zhongNum = nums[zhong];
                for (; right > zhong && nums[right]>=0; right--) {
                    if (right != nums.length - 1 && nums[right] == nums[right + 1]) {
                        continue;
                    }
                    rightNum = nums[right];
                    if (leftNum + zhongNum + rightNum == 0) {
                        result.add(returnList(leftNum, zhongNum, rightNum));
                        break;
                    } else if (leftNum + zhongNum + rightNum < 0) {
                        break;
                    }
                }
            }
            left++;
        }
        return result;
    }

    public static List<Integer> returnList(int n1, int n2, int n3) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(n1);
        list.add(n2);
        list.add(n3);
        return list;
    }
}
