package leetcode.util;

/**
 * @author machao
 * @date 2019/12/26
 */
public class Timer {
    private volatile long startTime;
    private volatile long endTime;

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void end() {
        endTime = System.currentTimeMillis();
        System.err.println(endTime - startTime);
    }

    public long duration() {
        return endTime - startTime;
    }
}
