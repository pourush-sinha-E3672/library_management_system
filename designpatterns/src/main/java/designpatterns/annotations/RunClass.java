package designpatterns.annotations;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

/**
 * Created by pourush.sinha on 21/06/18.
 */




class WorkFlowExecutor <T> {

    public T ExecutMethod(String featureName, Map<String, Object> entityMap, Class<? extends Annotation> annotation, Object... obj) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forJavaClassPath()).setScanners(
                        new MethodAnnotationsScanner()));
        Set<Method> methods = reflections.getMethodsAnnotatedWith(annotation);
        for (Method m : methods) {
            AB a = m.getAnnotation(AB.class);
            if (a.name().equals(featureName)) {
                return (T) m.invoke(TestClass.class.newInstance(), obj);
            }

        }

        return  null;
    }

}

public class RunClass {



    @AB(name = "feature1")
    public  String calledcs(String abc) {
        return abc + " feature1";
    }

    @AB(name = "feature2")
    public   String calledcs2(String abc) {

        return abc + " feature2";
    }



    public static void main(String args[]) throws Exception {
        WorkFlowExecutor<String> workFlowExecutor = new WorkFlowExecutor<String>();
        String output = workFlowExecutor.ExecutMethod("feature3", null, AB.class, "executing work flow");
        System.out.print(output);

    }

}


