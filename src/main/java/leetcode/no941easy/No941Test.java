package leetcode.no941easy;

/**
 * @author machao
 * @date 2020/11/3
 */
public class No941Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validMountainArray(new int[]{0,3,2,1}));
        System.out.println(solution.validMountainArray(new int[]{3,5,5}));
        System.out.println(solution.validMountainArray(new int[]{2,1}));
        System.out.println(solution.validMountainArray(new int[]{0,2,3,5,2,1,0}));
        System.out.println(solution.validMountainArray(new int[]{0,1,2,3,4,5,6,7,8,9}));
    }
}
