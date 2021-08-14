package leetcode.easy.no1103;

/**
 * 1103. 分糖果 II
 * 排排坐，分糖果。
 * <p>
 * 我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
 * <p>
 * 给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
 * <p>
 * 然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。
 * <p>
 * 重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。
 * <p>
 * 返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：candies = 7, num_people = 4
 * 输出：[1,2,3,1]
 * 解释：
 * 第一次，ans[0] += 1，数组变为 [1,0,0,0]。
 * 第二次，ans[1] += 2，数组变为 [1,2,0,0]。
 * 第三次，ans[2] += 3，数组变为 [1,2,3,0]。
 * 第四次，ans[3] += 1（因为此时只剩下 1 颗糖果），最终数组变为 [1,2,3,1]。
 * 示例 2：
 * <p>
 * 输入：candies = 10, num_people = 3
 * 输出：[5,2,3]
 * 解释：
 * 第一次，ans[0] += 1，数组变为 [1,0,0]。
 * 第二次，ans[1] += 2，数组变为 [1,2,0]。
 * 第三次，ans[2] += 3，数组变为 [1,2,3]。
 * 第四次，ans[0] += 4，最终数组变为 [5,2,3]。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= candies <= 10^9
 * 1 <= num_people <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distribute-candies-to-people
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author machao
 * @date 2020/3/5
 */
class Solution {
    /**
     * 暴力方法，直接硬解。
     *
     * @param candies    糖果数量
     * @param num_people 人数
     * @return 每个人口袋里的糖数量
     */
    public int[] distributeCandies1(int candies, int num_people) {
        int[] pockets = new int[num_people];
        int give = 1;
        while (candies > 0) {
            for (int i = 0; i < num_people; i++, give++) {
                //判断剩余糖果够不够分给当前小朋友，不够的话全部给他，够得话会有剩余
                if (candies <= give) {
                    pockets[i] += candies;
                    candies = 0;
                } else {
                    pockets[i] += give;
                    candies -= give;
                }
            }
        }
        return pockets;
    }

    /**
     * 数学推算：
     * 假设有c颗糖，一共可以完整的分n次糖，这是一个等差序列，最后可能剩余r颗糖，显然r<n+1。根据等差序列求和公式n(n+1)/2+r=c……
     *
     * @param candies
     * @param num_people
     * @return
     */
    public int[] distributeCandies(int candies, int num_people) {
        int n = num_people;
        // how many people received complete gifts
        int p = (int) (Math.sqrt(2 * candies + 0.25) - 0.5);
        int remaining = (int) (candies - (p + 1) * p * 0.5);
        int rows = p / n, cols = p % n;

        int[] d = new int[n];
        for (int i = 0; i < n; ++i) {
            // complete rows
            d[i] = (i + 1) * rows + (int) (rows * (rows - 1) * 0.5) * n;
            // cols in the last row
            if (i < cols) {
                d[i] += i + 1 + rows * n;
            }
        }
        // 剩余的糖
        d[cols] += remaining;
        return d;
    }
}
