package basejava.deadlock;

class Deadlock implements Runnable {
    private FirstClass a = new FirstClass();
    private SecondClass b = new SecondClass();

    private Deadlock() {
        Thread.currentThread().setName("Главный поток");
        Thread t = new Thread(this, "Соперничающий поток");
        t.start();
        a.foo(b); // получить блокировку для объекта a в этом потоке исполнения
        System.out.println("Назад в главный поток");
    }

    public void run() {
        b.bar(a); // получить блокировку для объекта b в другом потоке исполнения
        System.out.println("Назад в другой поток");
    }

    public static void main(String[] args) {
        new Deadlock();
    }
}