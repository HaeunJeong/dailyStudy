import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class Main0710 {
    public static void main(String[] args) throws InterruptedException {
        //useProduceConsumer();
        justFixedThreadPool();
        return;



/*
        long mainInitTime = System.currentTimeMillis();
        System.out.println(String.format("Thread %s : ", Thread.currentThread()));
        System.out.println("Thread life cycle : main new");




        while (true) {

            TestThread thread = new TestThread();

            System.out.println(String.format("Thread %s: start",Thread.currentThread()));
            thread.start();
            while (true) {
                if (System.currentTimeMillis() > mainInitTime + 500) {
                    System.out.println(String.format("Thread %s: setFalse",Thread.currentThread()));
                    thread.setFalse();
                    break;
                }
            }
            if(!thread.isAlive()){
                break;
            }
        }

        System.out.println("Thread life cycle : ??");

        return;
    }

*/
    }

    private static void justFixedThreadPool() throws InterruptedException {

        long startTime = System.nanoTime();
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Map<String, Integer> countMap = new HashMap<>();

        for(int i=0; i<10000; i++){
            int finalI = i;
            executor.submit(() -> {
                countMap.put(Thread.currentThread().getName(), countMap.getOrDefault(Thread.currentThread().getName(),0)+1);
                System.out.println(String.format("%s : %d", Thread.currentThread().getName(), finalI));
            });
        }
        executor.shutdown();
        while(executor.awaitTermination(3000, TimeUnit.MILLISECONDS)){
            if(executor.isShutdown()){
                System.out.println(countMap);
                break;
            }
        }
        System.out.println(System.nanoTime()-startTime);
    }
    private static void useProduceConsumer() throws InterruptedException {

        long startTime = System.nanoTime();
        ExecutorService producer = Executors.newSingleThreadExecutor();
        ExecutorService consumer = Executors.newFixedThreadPool(3);
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        Map<String, Integer> countMap = new HashMap<>();

        producer.submit(()->{
            for(int i=0; i<10000; i++){
                try {
                    queue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        for(int i=0; i<3; i++){
            consumer.submit(()->{
                while(true) {
                    if(producer.isShutdown() && queue.isEmpty()) break;
                    if (!queue.isEmpty()) {
                        try {
                            countMap.put(Thread.currentThread().getName(), countMap.getOrDefault(Thread.currentThread().getName(), 0) + 1);
                            System.out.println(String.format("%s : %d", Thread.currentThread().getName(), queue.take()));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }

        producer.shutdown();
        consumer.shutdown();
        while(consumer.awaitTermination(3000, TimeUnit.MILLISECONDS)){
            if(consumer.isShutdown()){
                System.out.println(countMap);
                break;
            }
        }
        System.out.println(System.nanoTime()-startTime);

    }

}
