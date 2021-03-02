package algorithms.number;

import java.util.*;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: fuzf
 * @Date: 2021/3/2 23:12
 */
public class HeBingQuJianMain {

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {7, 9}, {4, 8}, {9, 12}};
        System.out.println(Arrays.deepToString(arr));
        System.out.println(Arrays.deepToString(solution(arr)));
    }


    public static int[][] solution(int[][] intervals) {
        Arrays.sort(intervals, new ArraySort());
        List<int[]> ansList = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (ansList.isEmpty()) {
                ansList.add(intervals[i]);
            } else {
                int[] rightArr = ansList.get(ansList.size() - 1);
                if (rightArr[1] >= intervals[i][0]) {
                    if (rightArr[1] >= intervals[i][1]) {
                        continue;
                    } else {
                        rightArr[1] = intervals[i][1];
                        ansList.set(ansList.size() - 1, rightArr);
                    }
                } else {
                    ansList.add(intervals[i]);
                }
            }
        }

        return ansList.toArray(new int[ansList.size()][]);
    }


    static class ArraySort implements Comparator<int[]>{
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    }
}


