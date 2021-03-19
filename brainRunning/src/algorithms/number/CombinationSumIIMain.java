package algorithms.number;

import java.util.ArrayList;
import java.util.List;

/**
 * 不会 太复杂
 *
 * @Author: fuzf
 * @Date: 2021/3/1 22:19
 */
public class CombinationSumIIMain {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{10,1,2,7,6,1,5}, 8));
    }


    public static List<List<Integer>> solution(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        deal(candidates, target, ans, combine, 0);
        return ans;
    }

    public static void deal(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        deal(candidates, target, ans, combine, idx + 1);
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            deal(candidates, target - candidates[idx], ans, combine, idx + 1);
            combine.remove(combine.size() - 1);
        }

    }
}
