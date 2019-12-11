package exp_1;


public class Consumer implements Runnable {
    private DataCenter data;

    Consumer(DataCenter data) {
        this.data = data;
    }


    public void run() {
        while (true) {
            String msg;
            try {
                synchronized (data) {
                    while (data.isEmpty()) {
                        data.wait();
                    }
                    msg = data.getMsg();
                    data.notifyAll();
                    Thread.sleep(0);
                    System.out.println("read msg: " + msg + " Count: " + data.getCount());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
