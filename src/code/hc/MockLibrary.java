package code.hc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

interface TestInterface {
    int calculate(int a, int b);
    String calculate(String a, String b);
    String getValue();
}

public class MockLibrary implements InvocationHandler {
    private Map<String, Object> methodMappings = new HashMap<>();

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        if (methodMappings.containsKey(methodName)) {
            return methodMappings.get("invoke");
        }
        throw new UnsupportedOperationException("Method not mocked: " + methodName);
    }

    public MockLibrary when(String method, Object[] args) {
        // 특정 메서드와 인자에 대한 반환 값을 설정합니다.
        methodMappings.put(method, args);
        return this;
    }

    public void thenReturn(Object val) {
        // 메서드가 호출될 때 반환할 값을 설정합니다.
        methodMappings.put("invoke", val);
    }

    public static void main(String[] args) {
        MockLibrary handler = new MockLibrary();
        TestInterface ref = (TestInterface) Proxy.newProxyInstance(
                MockLibrary.class.getClassLoader(),
                new Class[]{TestInterface.class},
                handler
        );

        handler.when("calculate", new Object[] {1, 2}).thenReturn(3);
        handler.when("calculate", new Object[] {"a", "b"}).thenReturn("ab");

        System.out.println(ref.calculate(1, 2)); // prints 3
        System.out.println(ref.calculate("a", "b")); // prints "ab"
    }
}