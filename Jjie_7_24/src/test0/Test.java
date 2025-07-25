package test0;
class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("继承Thread类");
    }
}
class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("实现Runnable接口");
    }
}
public class Test {
//    继承 Thread, 重写 run
//    实现 Runnable, 重写 run
//    继承 Thread, 重写 run, 使用匿名内部类
//    实现 Runnable, 重写 run, 使用匿名内部类
//    使用 lambda 表达式
    public static void main(String[] args) {
        Thread t1=new MyThread();
        t1.start();

        Runnable r=new MyRunnable();
        Thread t2=new Thread(r);
        t2.start();

        Thread t3=new Thread(){
            @Override
            public void run() {
                System.out.println("继承Thread，匿名内部类");
            }
        };
        t3.start();

        Thread t4=new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("实现Runnable接口，匿名内部类");
            }
        });
        t4.start();

        Thread t5=new Thread(()->{
            System.out.println("lambda表达式");
        });
        t5.start();

    }
}
