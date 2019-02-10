package basejava.deadlock;

class SomeClass {
    private String className;

    public SomeClass(String className) {
        this.className = className;
    }

    synchronized void foo(SomeClass b) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " вошел в метод " + className + ".foo()");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Класс " + className + " прерван");
        }
        System.out.println(name + " пытается вызвать метод " + className + ".last()");
        b.last();
    }

    synchronized void last() {
        System.out.println("В методе " + className + ".last()");
    }

    public void setClassName(String className) {
        this.className = className;
    }
}