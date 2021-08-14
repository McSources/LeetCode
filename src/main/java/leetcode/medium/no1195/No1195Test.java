package leetcode.medium.no1195;

import leetcode.util.MyThreadPoolFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.IntConsumer;

/**
 * @author machao
 * @date 2021/6/14
 */
public class No1195Test {
    private static final List<String> LIST = new ArrayList<>();
    private static final Runnable PRINT_FIZZ = () -> LIST.add("fizz");
    private static final Runnable PRINT_BUZZ = () -> LIST.add("buzz");
    private static final Runnable PRINT_FIZZ_BUZZ = () -> LIST.add("fizzbuzz");
    private static final IntConsumer PRINT_NUMBER = (i) -> LIST.add(String.valueOf(i));

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(25);
        ExecutorService executor = MyThreadPoolFactory.getThreadPool(4);
        executor.execute(() -> {
            try {
                fizzBuzz.fizz(PRINT_FIZZ);
                System.out.println("fizz done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.execute(() -> {
            try {
                fizzBuzz.buzz(PRINT_BUZZ);
                System.out.println("buzz done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.execute(() -> {
            try {
                fizzBuzz.fizzbuzz(PRINT_FIZZ_BUZZ);
                System.out.println("fizzBuzz done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.execute(() -> {
            try {
                fizzBuzz.number(PRINT_NUMBER);
                System.out.println("number done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.shutdown();
        try {
            TimeUnit.SECONDS.sleep(2);
            LIST.stream().reduce((pre, cur) -> pre + "," + cur).ifPresent(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        try {
//            while (!executor.awaitTermination(500, TimeUnit.MILLISECONDS)) {}
//            LIST.stream().reduce((pre, cur) -> pre + "," + cur).ifPresent(System.out::println);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
