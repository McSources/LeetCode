package leetcode.no7easy;

/**
 * 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * 就是说不能用long
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author machao
 */
public class Solution {
    /**
     * 比较低级的用翻转字符串的方式实现
     * @param x 要被翻转的数字
     * @return 被反转的数字
     */
    public int reverse(int x) {
        StringBuilder numb = new StringBuilder(String.valueOf(x));
        numb = numb.reverse();
        String numbStr;
        if (numb.indexOf("-") > -1) {
            numb.setLength(numb.length() - 1);
            numbStr = "-"+numb.toString();
        }else{
            numbStr = numb.toString();
        }
        int i;
        try {
            i = Integer.parseInt(numbStr);
            return i;
        } catch (NumberFormatException e){
            return 0;
        }
    }

    /**
     * 用数学的方式处理
     * @param x 要被翻转的数字
     * @return 被反转的数字
     */
    public int reverse2(int x){
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }
}
