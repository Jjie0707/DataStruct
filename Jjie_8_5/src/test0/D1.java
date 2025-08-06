package test0;

class MyBlockingqueue {
    private int[] array=null;
    private int capacity=0;
    private int size=0;
    private int head=0;
    private int tail=0;

    private final Object  lock=new Object();


    public MyBlockingqueue(int capacity){
        this.capacity=capacity;
        array=new int[capacity];
    }

    public void put(int elem) throws InterruptedException {
        synchronized(lock){
            while (size == capacity) {
                lock.wait();
            }
            array[tail]=elem;
            size++;
            tail=(tail+1)%this.capacity;

            lock.notifyAll();
        }
    }
    public int get() throws InterruptedException {
        synchronized(lock){
            while(size==0){
                lock.wait();
            }

            size--;
            int tem=array[head];

            head=(head+1)%this.capacity;

            lock.notifyAll();
            return tem;
        }
    }
}
public class D1 {
    public static void main(String[] args) {
        MyBlockingqueue bq=new MyBlockingqueue(10);

        //t1作为生产者，有时停地生产
        Thread t1=new Thread(()->{
            int n=0;
            while(true){
                try {
                    bq.put(n);
                    System.out.println("生产了一个"+n);
                    n++;
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2=new Thread(()->{
            while(true){
                try {
                    int tem=bq.get();
                    System.out.println("消费者消费了一个"+tem);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
    }
}
