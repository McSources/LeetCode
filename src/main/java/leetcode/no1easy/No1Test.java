package leetcode.no1easy;

import leetcode.util.Timer;

import java.util.Arrays;

class No1Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3, 7, 11, 6};
        int target = 9;
        Timer timer = new Timer();
        timer.start();
        int[] result = solution.twoSum2(nums, target);
        timer.end();
        System.out.println(Arrays.toString(result));
    }
}
