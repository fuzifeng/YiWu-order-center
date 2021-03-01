package algorithms.number;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fuzf
 */
public class CombinationSumMain {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 3, 6, 7}, 7));
    }


    public static List<List<Integer>> solution(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates, target, result, combine, 0);
        return result;
    }

    private static void dfs(int[] candidates, int target, List<List<Integer>> result, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(combine));
            return;
        }
        //直接跳过处理下一索引数据
        dfs(candidates, target, result, combine, idx + 1);
        //当前分支
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], result, combine, idx);
            /**
             * 回溯框架，进行下一步之前加入当前节点，下一步递归过之后，要把当前节点从路径中删除，所以才是“回溯”。不然只增不减，结果路径中的值不就越来越多了嘛
             */
            combine.remove(combine.size() - 1);

        }
    }
}
