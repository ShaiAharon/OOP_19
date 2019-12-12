package exp_2;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    // Maximum number of threads in thread pool
    static final int MAX_SIZE = 3;

    public static void main(String[] args) {
        ArrayList<Runnable> run_arr = new ArrayList<>();
        for (int i = 0; i < 15; ++i) {
           run_arr.add(new Task("task " + i));
        }

        ExecutorService pool = Executors.newFixedThreadPool(MAX_SIZE);

        for(Runnable tmp_run : run_arr){
        	pool.execute(tmp_run);
		}
        pool.shutdown();
    }
} 
