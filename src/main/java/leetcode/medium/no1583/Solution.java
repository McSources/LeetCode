package leetcode.medium.no1583;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1583. 统计不开心的朋友
 * 给你一份 n 位朋友的亲近程度列表，其中 n 总是 偶数 。
 * <p>
 * 对每位朋友 i，preferences[i] 包含一份 按亲近程度从高到低排列 的朋友列表。换句话说，排在列表前面的朋友与 i 的亲近程度比排在列表后面的朋友更高。每个列表中的朋友均以 0 到 n-1 之间的整数表示。
 * <p>
 * 所有的朋友被分成几对，配对情况以列表 pairs 给出，其中 pairs[i] = [xi, yi] 表示 xi 与 yi 配对，且 yi 与 xi 配对。
 * <p>
 * 但是，这样的配对情况可能会是其中部分朋友感到不开心。在 x 与 y 配对且 u 与 v 配对的情况下，如果同时满足下述两个条件，x 就会不开心：
 * <p>
 * x 与 u 的亲近程度胜过 x 与 y，且
 * u 与 x 的亲近程度胜过 u 与 v
 * 返回 不开心的朋友的数目 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, preferences = [[1, 2, 3], [3, 2, 0], [3, 1, 0], [1, 2, 0]], pairs = [[0, 1], [2, 3]]
 * 输出：2
 * 解释：
 * 朋友 1 不开心，因为：
 * - 1 与 0 配对，但 1 与 3 的亲近程度比 1 与 0 高，且
 * - 3 与 1 的亲近程度比 3 与 2 高。
 * 朋友 3 不开心，因为：
 * - 3 与 2 配对，但 3 与 1 的亲近程度比 3 与 2 高，且
 * - 1 与 3 的亲近程度比 1 与 0 高。
 * 朋友 0 和 2 都是开心的。
 * 示例 2：
 * <p>
 * 输入：n = 2, preferences = [[1], [0]], pairs = [[1, 0]]
 * 输出：0
 * 解释：朋友 0 和 1 都开心。
 * 示例 3：
 * <p>
 * 输入：n = 4, preferences = [[1, 3, 2], [2, 3, 0], [1, 3, 0], [0, 2, 1]], pairs = [[1, 3], [0, 2]]
 * 输出：4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 500
 * n 是偶数
 * preferences.length == n
 * preferences[i].length == n - 1
 * 0 <= preferences[i][j] <= n - 1
 * preferences[i] 不包含 i
 * preferences[i] 中的所有值都是独一无二的
 * pairs.length == n/2
 * pairs[i].length == 2
 * xi != yi
 * 0 <= xi, yi <= n - 1
 * 每位朋友都 恰好 被包含在一对中
 *
 * @author machao
 * @date 2021/8/14
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int count = solution.unhappyFriends(2, new int[][]{{1}, {0}}, new int[][]{{1, 0}});
        System.out.println(count);
    }

    /**
     * 第一版 用map
     */
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] orders = new int[n][n];
        for (int i = 0; i < preferences.length; i++) {
            for (int j = 0; j < preferences[i].length; j++) {
                orders[i][preferences[i][j]] = j;
            }
        }
        Map<Integer, Integer> pairMap = new HashMap<>(pairs.length * 2);
        for (int[] pair : pairs) {
            pairMap.put(pair[0], pair[1]);
            pairMap.put(pair[1], pair[0]);
        }
        Set<Integer> unhappyPerson = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : pairMap.entrySet()) {
            int x = entry.getKey();
            int y = entry.getValue();
            //x 对 y 的亲密度
            int intimacy = orders[x][y];
            if (intimacy > 0) {
                //遍历比起y，x更喜欢的人
                for (int i = 0; i < intimacy; i++) {
                    //比起y，x更喜欢的某个人
                    int u = preferences[x][i];
                    //跟这个人配对的人
                    int v = pairMap.get(u);
                    if (orders[u][x] < orders[u][v]) {
                        unhappyPerson.add(x);
                        unhappyPerson.add(u);
                    }
                }
            }
        }
        return unhappyPerson.size();
    }

    /**
     * 改良 用数组
     */
    public int unhappyFriends2(int n, int[][] preferences, int[][] pairs) {
        int[][] orders = new int[n][n];
        for (int i = 0; i < preferences.length; i++) {
            for (int j = 0; j < preferences[i].length; j++) {
                orders[i][preferences[i][j]] = j;
            }
        }
        //因为每个人只会跟一个人配对，所以完全可以用数组代替map
        int[] pairMatch = new int[n];
        for (int[] pair : pairs) {
            pairMatch[pair[0]] = pair[1];
            pairMatch[pair[1]] = pair[0];
        }
        Set<Integer> unhappyPerson = new HashSet<>();
        for (int x = 0; x < pairMatch.length; x++) {
            int y = pairMatch[x];
            //x 对 y 的亲密度
            int intimacy = orders[x][y];
            if (intimacy > 0 && !unhappyPerson.contains(x)) {
                //遍历比起y，x更喜欢的人
                for (int i = 0; i < intimacy; i++) {
                    //比起 y，x 更喜欢的某个人
                    int u = preferences[x][i];
                    //跟 u 配对的人
                    int v = pairMatch[u];
                    //比起 v ，u 是不是更喜欢 x
                    if (orders[u][x] < orders[u][v]) {
                        unhappyPerson.add(x);
                        unhappyPerson.add(u);
                    }
                }
            }
        }
        return unhappyPerson.size();
    }
}
