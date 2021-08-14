package leetcode.easy.no941;

/**
 * 941. 有效的山脉数组
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 *
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 *
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *
 *
 * [0 2 3 4 5 2 1 0] 是山脉数组
 *
 *
 * [0 2 3 3 5 2 1 0] 不是山脉数组
 * 示例 1：
 *
 * 输入：[2,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：[3,5,5]
 * 输出：false
 * 示例 3：
 *
 * 输入：[0,3,2,1]
 * 输出：true
 *
 *
 * 提示：
 *
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author machao
 * @date 2020/11/3
 */
class Solution {

    private static final int MIN_LENGTH = 3;
    private static final int SECOND_TO_LAST = 2;

    /**
     * 双指针从两侧开始找最高点（满足前者大于后者），看两侧找到的最高点是否相同即可
     * @param A 待校验的数组
     * @return true或false
     */
    public boolean validMountainArray(int[] A) {
        if(A.length >= MIN_LENGTH){
            int left = 0, right = A.length - 1;
            while(left < A.length - SECOND_TO_LAST && A[left] < A[left+1]){
                left++;
            }
            while(right > 1 && A[right] < A[right-1]){
                right--;
            }
            return left == right;
        }else {
            return false;
        }
    }
}

