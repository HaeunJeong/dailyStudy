import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main0710 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //useProduceConsumer();
        justFixedThreadPool();
        //System.out.println(Runtime.getRuntime().availableProcessors()); //코어 사이즈

        return;

    }

    private static void justFixedThreadPool() throws InterruptedException {
        int THREAD_COUNT = 20;
        BlockingQueue<Integer> jobs = IntStream.rangeClosed(1,1000).boxed().collect(Collectors.toCollection(LinkedBlockingQueue::new));
        Map<String, Integer> countMap = new HashMap<>();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        List<Future<Integer>> results = new ArrayList<>();

        long startTime = System.nanoTime();

        for(int i=0; i<THREAD_COUNT; i++){

            Future<Integer> future = executor.submit(() -> {
                while(!jobs.isEmpty()) {
                    try {
                        Integer job = jobs.take();
                        countMap.put(Thread.currentThread().getName(), countMap.getOrDefault(Thread.currentThread().getName(), 0) + 1);
                        System.out.println(String.format("%s : %d", Thread.currentThread().getName(), job));

                        Thread.sleep(20);
                    } catch (NoSuchElementException e) {
                        System.out.println("NoSuchElementException");
                        continue;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                return 1;
            });
            results.add(future);
        }
        while(results.size()==THREAD_COUNT){
            executor.shutdown();
            break;
        }

        while (executor.awaitTermination(50000, TimeUnit.MILLISECONDS)) {
            if (executor.isShutdown()) {
                System.out.println(countMap);
                System.out.println(System.nanoTime()-startTime);
                break;
            }
        }

    }
    private static void useProduceConsumer() throws InterruptedException, ExecutionException {

        int PRODUCER_THREAD_COUNT = 10;
        int CONSUMER_THREAD_COUNT = 10;
        BlockingQueue<Integer> jobs = IntStream.rangeClosed(1,1000).boxed().collect(Collectors.toCollection(LinkedBlockingQueue::new)); //DEQUE 에서 BlockingQueue로 바꾸니까, take()할때 동기화가 되면서 작업 분배가 훨씬 빨라짐.
        ExecutorService producer = Executors.newFixedThreadPool(PRODUCER_THREAD_COUNT); //DB에 넣기 전 체크 & 거르는 작업만.
        ExecutorService consumer = Executors.newFixedThreadPool(CONSUMER_THREAD_COUNT); //DB에 insert 하는 작업만.
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        Map<String, Integer> countMap = new HashMap<>();
        List<Future<Integer>> producerResults = new ArrayList<>();
        List<Future<Integer>> consumerResults = new ArrayList<>();

        long startTime = System.nanoTime();

        for(int j=0; j<PRODUCER_THREAD_COUNT; j++) {
            Future<Integer> future = producer.submit(() -> {

                while(!jobs.isEmpty()) {
                    try {
                        //동기화가 굳이 필요할까??
                        Integer i = jobs.take();
                        Thread.sleep(10); //거르는 작업이 10ms
                        queue.put(i);

                    } catch (NoSuchElementException e) {
                        System.out.println("NoSuchElementException");
                        continue;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                return 1;
            });
            producerResults.add(future);
        }
        IntStream.range(0,CONSUMER_THREAD_COUNT).parallel().forEach( i-> {
                    Future<Integer> future = consumer.submit(() -> {
                        while (true) {
                            if (producer.isShutdown() && queue.isEmpty()) break;
                            //if(queue.isEmpty()) Thread.sleep(10);
                            try {
                                Integer job = queue.take();
                                countMap.put(Thread.currentThread().getName(), countMap.getOrDefault(Thread.currentThread().getName(), 0) + 1);
                                System.out.println(String.format("%s : %d", Thread.currentThread().getName(), job));

                                Thread.sleep(10);
                            } catch (InterruptedException e) {
                                continue;
                            }

                        }
                        return 1;
                    });
                    consumerResults.add(future);
                }
            );
        while(producerResults.size()==PRODUCER_THREAD_COUNT){
            producer.shutdown();
            break;
        }
        while(consumerResults.size()==CONSUMER_THREAD_COUNT){
            consumer.shutdown();
            break;
        }


        while (producer.awaitTermination(50000, TimeUnit.MILLISECONDS) && consumer.awaitTermination(50000, TimeUnit.MILLISECONDS)) {
            if (producer.isShutdown() && consumer.isShutdown()) {
                System.out.println(countMap);
                System.out.println(System.nanoTime()-startTime);
                break;
            }
        }
    }

}
