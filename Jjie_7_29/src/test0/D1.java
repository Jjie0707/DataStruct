package test0;

public class D1 {
    public static void main(String[] args) {
        Object obj=new Object();
        Thread t1=new Thread(()->{


            synchronized(obj){
                System.out.println("t1 wait之前");
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2=new Thread(()->{
            synchronized(obj){
                System.out.println("t2 wait之前");
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t3=new Thread(()->{
            synchronized(obj){
                System.out.println("t3 wait之前");
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t4=new Thread(()->{
            synchronized(obj){
                System.out.println("t4 wait之前");
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        //  随机调度一个线程之后，wait释放掉当前持有的锁
        //  再随机调用一个线程 重复第一个调用线程的操作 直到四个线程都进入堵塞状态
    }
}
