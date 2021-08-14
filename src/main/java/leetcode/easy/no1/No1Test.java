package leetcode.easy.no1;

import java.util.Arrays;

class No1Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3, 7, 11, 6};
        int target = 9;
        int[] result = solution.twoSum2(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
