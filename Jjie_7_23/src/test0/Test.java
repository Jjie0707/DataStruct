package test0;

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println(666);
    }
}
public class Test {
    public static void main(String[] args) {
        Thread T=new MyThread();
        T.start();

        System.out.println(888);
        //888和666出现的顺序是随机的 取决于操作系统的调度

    }
}
