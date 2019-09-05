package leetcode.no1114easy;

import java.util.concurrent.*;

public class No1114Test {
    public static void main(String[] args) {
        try {
            transfer(new int[]{3,2,1});
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据入参顺序调用不同的方法
     * @param in 必须是1,2,3的排列组合
     * @throws InterruptedException 受检异常
     */
    private static void transfer(int[] in) throws InterruptedException {
        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        Foo solution = new Foo();
        for(int i : in){
            switch (i){
                case 1:
                    threadPool.submit(()->{
                        try {
                            solution.first(() -> {
                                System.out.print("one");
                            });
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                    break;
                case 2:
                    threadPool.submit(()->{
                        try {
                            solution.second(() -> {
                                System.out.print("two");
                            });
                        }catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        });
                    break;
                case 3:
                    threadPool.submit(()->{
                        try {
                            solution.third(() -> {
                                System.out.print("three");
                            });
                        }catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                    break;
                default:
                    break;
            }
        }
        threadPool.shutdown();
    }
}
