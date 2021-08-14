package leetcode.hard.no57;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 57. 插入区间
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 * @author machao
 * @date 2020/11/4
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] ret;
        int left = 0, right = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] <= newInterval[0] && intervals[i][1] >= newInterval[0]) {
                left = i;
            }
            if (intervals[i][0] <= newInterval[1] && intervals[i][1] >= newInterval[1]) {
                right = i;
            }
        }
        //为了方便操作将 intervals 转换成列表
        LinkedList<int[]> intervalsList = new LinkedList<>(Arrays.asList(intervals));
        if (left == 0 && right == 0) {
            if (intervals[0][0] > newInterval[1]) {
                intervalsList.add(0, newInterval);
            } else {
                intervalsList.add(newInterval);
            }
            ret = intervalsList.toArray(new int[intervalsList.size()][]);
        } else if (left == right) {
            ret = intervals;
        } else {
            int[] intervalTemp = new int[]{intervals[left][0], intervals[right][1]};
            intervalsList.subList(left, right + 1).clear();
            intervalsList.add(left, intervalTemp);
            ret = intervalsList.toArray(new int[intervalsList.size()][]);
        }
        return ret;
    }

    public int[][] insert2(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> intervalsList = new LinkedList<>(Arrays.asList(intervals));
        intervalsList.add(newInterval);
        intervalsList.sort((Comparator.comparingInt(o -> o[0])));
        return null;
    }
}
