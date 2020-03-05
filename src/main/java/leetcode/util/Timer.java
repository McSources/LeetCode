package leetcode.util;

/**
 * 计时器
 * TODO
 * <ol>
 *     <li>允许设置时间单位</li>
 *     <li>允许选择，程序执行中打印日志还是执行结束之后统一打印日志，需要有一个list记录时间和日志信息</li>
 * </ol>
 *
 * @author machao
 * @date 2019/12/26
 */
public class Timer {
    private long startTime;

    /**
     * 开始计时，设置开始时间
     */
    public void start() {
        startTime = System.currentTimeMillis();
    }

    /**
     * 计算间隔，打印花费的时间
     */
    public void duration() {
        System.err.println(System.currentTimeMillis() - startTime);
    }
}
