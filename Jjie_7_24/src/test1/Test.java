package test1;

public class Test {
    private static int result =0;
//    public static void main(String[] args) throws InterruptedException {
//        Thread t=new Thread(()->{
//            for(int i=0;i<=10;i++) result +=i;
//            System.out.println("t线程执行完毕");
//        });
//        t.start();
//        t.join();
//        System.out.println(result);
//    }
    public static void main(String[] args){
        Thread mainThread=Thread.currentThread();

        Thread t=new Thread(()->{
            try {
                mainThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(result);
        });

        t.start();

        for(int i=0;i<=1000;i++) result+=i;

    }
}
