public class TestThread extends Thread{
    private boolean flag = true;

    public long getStartTime() {
        return startTime;
    }

    private static long startTime = System.currentTimeMillis();

    public void setFalse(){
        this.flag = false;
    }
    public TestThread(){
        System.out.println(String.format("init time : %d", startTime));
    }
    @Override
    public void run(){
        try {
            while(flag){
                System.out.println(String.format("Thread %s: running",Thread.currentThread()));

                Thread.sleep(100);
            }

            System.out.println(String.format("Thread %s: terminated",Thread.currentThread()));
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}