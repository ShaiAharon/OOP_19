package exp_2;

public class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    public void run() {
        try {
            System.out.println(name + " Started!");
            for (int i = 0; i <= 5; i++) {
                System.out.println("Executing task: " + name);

                Thread.sleep(100);
            }

            System.out.println(name + " complete");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
} 
