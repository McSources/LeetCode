package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author machao
 * @date 2021/8/17
 */
public class Test {
    public static void main(String[] args) {
//        Test obj = new Test();
//        System.out.println(obj.hashCode());
//        System.out.println(obj.hashCode()>>>16);
//        System.out.println(obj.hashCode());
//        System.out.println(obj.hashCode()^(obj.hashCode()>>>16));
//        Map<String,String> map = new HashMap<>();
//        for (int i = 0; i < 20; i++) {
//            map.put(String.valueOf(i),i+""+i+1);
//        }
        MyThread thread = new MyThread();
        thread.start();
    }
}

class MyThread extends Thread{

    @Override
    public void run() {
        int i = 0;
        while (true){
            if(i == 10){
                this.interrupt();
                System.out.println("中断在 10 ");
            }
            try {
                Thread.sleep(500);
                System.out.println(i++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
