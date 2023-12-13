public class MyClass {
    @MyAnnotation(value = 2)
    public void publicMethod() {
        System.out.println("Вызван публичный метод");
    }

    @MyAnnotation(value = 3)
    protected void protectedMethod() {
        System.out.println("Вызван защищенный метод");
    }

    @MyAnnotation(value = 1)
    private void privateMethod() {
        System.out.println("Вызван приватный метод");
    }
}
