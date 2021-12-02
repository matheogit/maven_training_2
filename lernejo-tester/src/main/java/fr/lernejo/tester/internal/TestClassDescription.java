package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class TestClassDescription {
    Class<?> aClass;
    public TestClassDescription(Class<?> aClass){
        this.aClass = aClass;
    }
    public List<Method> listTestMethods(){
        Method[] methods = this.aClass.getDeclaredMethods();
        List<Method> list_methods = new ArrayList<>();
        for (Method method : methods) {
            if (Modifier.isPublic(method.getModifiers()) && method.getReturnType().equals(Void.TYPE) && method.getParameters().length == 0 && method.getAnnotation(TestMethod.class) != null)
                list_methods.add(method);
        }
        return list_methods;
    }
}
