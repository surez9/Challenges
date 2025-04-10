package practice.collections.concurrent;

import java.util.ArrayList;
import java.util.List;

public class NotThreadSafeExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("four");
        list.add("five");

        Runnable t1 = () ->{
            //thread 1 - task
            for (String str: list){
                System.out.println(str);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable t2 = ()->{
           //thread 2 -task
            list.add("new item 1");
            list.add("new item 2");
            list.add("new item 3");
        } ;

        new Thread(t1).start();
        new Thread(t2).start();
    }
}
