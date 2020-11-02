package leetcode.no1easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author machao
 * @date 2019/12/26
 */
class Solution {
    /**
     * 硬解法，直接遍历两遍
     *
     * @param nums   整数数组
     * @param target 目标值
     * @return 两个数的下标
     */
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        loop1:
        while (ret[0] < nums.length - 1) {
            for (int i = ret[0] + 1; i < nums.length; i++) {
                if (nums[ret[0]] + nums[i] == target) {
                    ret[1] = i;
                    break loop1;
                }
            }
            ret[0] += 1;
        }
        return ret;
    }

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> numsMap = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            numsMap.put(i,nums[i]);
        }
        return null;
    }
}
