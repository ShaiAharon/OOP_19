package exp_1;

public class Main
{
	public static void main(String[] args) throws InterruptedException 
	{
		DataCenter data = new DataCenter();

		Producer producer = new Producer(data);
		Consumer consumer = new Consumer(data);
		Consumer consumer1 = new Consumer(data);


		Thread p1 = new Thread(producer);
		Thread p2 = new Thread(producer);
		Thread p3 = new Thread(producer);
		
		Thread c4 = new Thread(consumer);
		Thread c5 = new Thread(consumer1);
		
		p1.start();
		p2.start();
		p3.start();

		c4.start();
		c5.start();
	}
}
