package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestClassDiscoverer {
    String package_name;
    public TestClassDiscoverer(String package_name){
        this.package_name = package_name;
    }
    public List<TestClassDescription> listTestClasses(){
        Reflections reflections = new Reflections(this.package_name, new SubTypesScanner(false));
        Set<Class<?>> allTypes = reflections.getSubTypesOf(Object.class);

        List<TestClassDescription> list_TestClassDescriptions = new ArrayList<>();
        for (Class<?> type : allTypes) {
            Method[] methods = type.getMethods();
            for (Method method : methods) {
                if(method.getAnnotation(TestMethod.class) != null && type.getName().endsWith("LernejoTests")){
                    list_TestClassDescriptions.add(new TestClassDescription(type));
                    break;
                }
            }
        }

        return list_TestClassDescriptions;
    }
}
