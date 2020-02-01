package cn.com.sky.spring.ioc.cycle_dependency.demo;


public class TestB {

    private TestA testA;

    public void b() {
        testA.a();
    }

    public TestA getTestA() {
        return testA;
    }

    public void setTestA(TestA testA) {
        this.testA = testA;
    }
}
