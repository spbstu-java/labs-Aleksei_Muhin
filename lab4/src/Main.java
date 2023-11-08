package annotclass;

import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) {
        AnnotClass myObject = new AnnotClass();
        Class<?> myClass = myObject.getClass();
        Method[] methods = myClass.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(AnnotRepeat.class)) {
                AnnotRepeat annotation = method.getAnnotation(AnnotRepeat.class);
                int repeatCount = annotation.count(); // изменение value() на count()

                if (Modifier.isPrivate(method.getModifiers()) || Modifier.isProtected(method.getModifiers())) {
                    method.setAccessible(true);

                    for (int i = 0; i < repeatCount; i++) {
                        try {
                            method.invoke(myObject);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }
}
