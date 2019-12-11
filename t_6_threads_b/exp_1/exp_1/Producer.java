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
                String msg = "" + counterMsg++;
                synchronized (data) {
					while (data.isFull()) {
						data.wait();
					}
					data.setMsg(msg);
					data.notifyAll();
					Thread.sleep(0);
				}
            } catch (InterruptedException e) {
                System.out.println("Somthing went wrong");
            }
        }
    }
}
