package reflection;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ExceptionThrowerTest {

    @Test(expected = InvocationTargetException.class)
    public void test() throws Exception {
        Method method = ExceptionThrower.class.getDeclaredMethod("throwException");
        method.invoke(new ExceptionThrower());
    }
}
