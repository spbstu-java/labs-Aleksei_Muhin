package annotclass;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface AnnotRepeat {
    int count() default 1;
}

public class AnnotClass {
    @AnnotRepeat(count = 3)
    public void openMethod() {
        System.out.println("Open method");
    }

    @AnnotRepeat(count = 4)
    protected void protectedMethod() {
        System.out.println("Protected method");
    }

    @AnnotRepeat(count = 5)
    private void secretMethod() {
        System.out.println("Secret method");
    }
}
