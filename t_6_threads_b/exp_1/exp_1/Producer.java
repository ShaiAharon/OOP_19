package exp_1;


public class Producer implements Runnable {
    private DataCenter data;
    private int counterMsg = 0;

    Producer(DataCenter data) {
        this.data = data;
    }

    public void run() {
        while (true) {
            try {
                synchronized (data) {
                    while (data.isFull()) {
                        System.out.println("Producer- wait");
                        data.wait();
                    }
                    String msg = "" + counterMsg++;
                    data.setMsg(msg);
                    data.notifyAll();
                }
              Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("Somthing went wrong");
            }
        }
    }
}
