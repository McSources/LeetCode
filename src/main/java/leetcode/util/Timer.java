package leetcode.util;

/**
 * @author machao
 * @date 2019/12/26
 */
public class Timer {
    private long startTime;
    private long endTime;

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void end() {
        endTime = System.currentTimeMillis();
    }

    public long duration() {
        return endTime - startTime;
    }
}
