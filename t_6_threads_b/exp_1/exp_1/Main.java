package exp_1;

public class Main
{
	public static void main(String[] args) throws InterruptedException 
	{
		DataCenter data = new DataCenter();
		
		Producer producer = new Producer(data);
		Consumer consumer = new Consumer(data);
	

		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(producer);
		Thread t3 = new Thread(producer);
		
		Thread t4 = new Thread(consumer);
		Thread t5 = new Thread(consumer);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		

	}
}
