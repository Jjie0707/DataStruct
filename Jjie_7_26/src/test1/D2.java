package test1;

public class D2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(()-> System.out.println(1));
        Thread t2=new Thread(()-> System.out.println(2));
        Thread t3=new Thread(()-> System.out.println(3));
        Thread t4=new Thread(()-> System.out.println(4));
        Thread t5=new Thread(()-> System.out.println(5));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        System.out.println("ok");
    }
}
