import java.lang.reflect.Method;

public class AnotherClass {
    public static void main(String[] args) throws Exception {
        MyClass myClass = new MyClass();

        Class<?> cls = myClass.getClass();

        for (Method method : cls.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
                int value = annotation.value();

                for (int i = 0; i < value; i++) {
                    method.setAccessible(true); // Разрешаем вызов приватных методов
                    method.invoke(myClass);
                }
            }
        }
    }
}
