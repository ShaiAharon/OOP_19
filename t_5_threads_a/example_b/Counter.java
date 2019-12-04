public class Counter {
    public int count;

    public synchronized void increment() {
        ++count;
    }
}
