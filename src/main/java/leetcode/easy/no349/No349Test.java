package leetcode.easy.no349;

import java.util.Arrays;

/**
 * @author machao
 * @date 2020/11/2
 */
public class No349Test {
    public static void main (String[] arg){
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.intersection(new int[]{1,2,2,1},new int[]{2,2})));
        System.out.println(Arrays.toString(solution.intersection(new int[]{4,9,5},new int[]{9,4,9,8,4})));
    }
}
