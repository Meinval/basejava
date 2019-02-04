package basejava.deadlock;

class FirstClass {
    synchronized void foo(SecondClass b) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " вошел в метод FirstClass.foo()");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Класс FirstClass прерван");
        }
        System.out.println(name + " пытается вызвать метод SecondClass.last()");
        b.last();
    }

    synchronized void last() {
        System.out.println("В методе FirstClass.last()");
    }
}