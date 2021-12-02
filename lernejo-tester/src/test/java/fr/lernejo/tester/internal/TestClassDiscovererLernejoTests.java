package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;
import org.assertj.core.api.Assertions;

import java.util.List;

class TestClassDiscovererLernejoTests {
    @TestMethod
    public void test_class_discoverer_of_package_fr_lernejo_tester_should_produce_3_class() throws NoSuchMethodException {
        TestClassDiscoverer testClassDiscoverer = new TestClassDiscoverer("fr.lernejo.tester");
        List<TestClassDescription> result = testClassDiscoverer.listTestClasses();
        /*List<TestClassDescription> expected = new ArrayList<>();
        expected.add(new TestClassDescription(TestClassDescription.class));
        expected.add(new TestClassDescription(TestClassDiscoverer.class));
        expected.add(new TestClassDescription(SomeLernejoTests.class));*/

        Assertions.assertThat(result).as("test class discoverer of package fr lernejo tester should produce 3 class")
            .size().isEqualTo(3);
    }
}
