import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyAnnotation {
    int value() default 1; // Целочисленный параметр аннотации, по умолчанию 1
}
