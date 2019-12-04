public class Main1 {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        CounterThread t1 = new CounterThread(c);
        CounterThread t2 = new CounterThread(c);
        t1.start();
        t2.start();

//		t1.join();
//		t2.join();
//        while (t2.isAlive() || t1.isAlive()) {
////            System.out.println(c.count);
//        }

        System.out.println("Final Count:" + c.count);
    }
}
