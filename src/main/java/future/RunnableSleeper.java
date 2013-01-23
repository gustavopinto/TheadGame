package future;

public class RunnableSleeper extends Sleeper implements Runnable {

    @Override
    public void run() {
        try {
            super.doStuff();
        } catch (InterruptedException ex) {
            throw new RuntimeException("Can't throw checked exceptions.", ex);
        }
    }
}