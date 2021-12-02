package fr.lernejo.tester.internal;


import fr.lernejo.tester.SomeLernejoTests;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import fr.lernejo.tester.api.TestMethod;
import org.assertj.core.api.Assertions;

class TestClassDescriptionLernejoTests {
    @TestMethod
    public void test_class_description_of_SomeLernejoTests_should_produce_ok_and_ko() throws NoSuchMethodException {
        Class<SomeLernejoTests> someLernejoTests = SomeLernejoTests.class;
        TestClassDescription testClassDescription = new TestClassDescription(someLernejoTests);
        List<Method> result = testClassDescription.listTestMethods();
        List<Method> expected = new ArrayList<>();
        expected.add(someLernejoTests.getMethod("ok"));
        expected.add(someLernejoTests.getMethod("ko"));

        Assertions.assertThat(result).as("public void without paremeter with annotation TestMethod of SomeLernejoTests")
            .isEqualTo(expected);
    }
}
