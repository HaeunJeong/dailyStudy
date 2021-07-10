public class Main0710 {
    public static void main(String[] args) throws InterruptedException {

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


}
