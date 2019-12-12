package exp_1;


public class Consumer implements Runnable {
    static int consumer_counter = 0;
    private int con_serial = consumer_counter++;
    private DataCenter data;

    Consumer(DataCenter data) {
        this.data = data;
    }


    public void run() {
        while (true) {
            String msg;
            try {
                synchronized (data) {
                    if (data.isEmpty()) {
                        System.out.println("Consumer- wait");
                        data.wait();
                    }
                    msg = data.getMsg();
                    data.notifyAll();
                    System.out.println("(" + con_serial + ") read msg: " + msg
                            + " Count: " + data.getCount());
                }
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
