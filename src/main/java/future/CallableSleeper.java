package future;

import java.util.concurrent.Callable;

public class CallableSleeper extends Sleeper implements Callable<Object> {

    @Override
    public Object call() throws Exception {
        return super.doStuff();
    }
}
