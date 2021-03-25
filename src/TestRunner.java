import java.lang.reflect.Method;

public class TestRunner {
    public static void main(String[] args) throws Exception {
        System.out.println("Running tests...");
        int passed = 0, failed = 0;

        String classname = args[0];
        for (Method method : Class.forName(classname).getMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                try {
                    method.invoke(null);
                    passed++;
                } catch (Exception e) {
                    System.err.printf("Test %s failed: %s %n", method, e.getCause());
                    failed++;
                }
            }
        }

        System.out.printf("Results: passed=%d, failed=%d %n", passed, failed);
    }
}
