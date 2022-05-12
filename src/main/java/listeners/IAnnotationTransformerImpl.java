package listeners;

import logger.TestLogger;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class IAnnotationTransformerImpl implements IAnnotationTransformer {

    // Through this we can set configuration for each test. Defining data provider, changing priority
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        TestLogger.INFO("Is Test Enabled? " + annotation.getEnabled());
    }
}
