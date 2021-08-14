package leetcode.util;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author machao
 * @date 2021/6/14
 */
public class MyThreadPoolFactory {
    public static final int DEFAULT_POOL_SIZE = 10;

    public static ExecutorService getThreadPool() {
        return new ThreadPoolExecutor(DEFAULT_POOL_SIZE, DEFAULT_POOL_SIZE << 1, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<>(20),
                new MyThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
    }

    public static ExecutorService getThreadPool(int corePoolSize) {
        return new ThreadPoolExecutor(corePoolSize, (corePoolSize >> 1) + corePoolSize, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<>(20),
                new MyThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
    }

    private static class MyThreadFactory implements ThreadFactory {
        private static final AtomicInteger P = new AtomicInteger();
        private final AtomicInteger t = new AtomicInteger();
        private final String prefix;

        private MyThreadFactory() {
            prefix = "P" + P.getAndIncrement();
        }

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, prefix + "T" + t.getAndIncrement());
        }
    }
}
