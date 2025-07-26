package test1;

import java.util.Random;

public class D1 {
    private static int e1=0;
    private static int e2=0;
    private static int[] nums=new int[1000000];
    public static void main(String[] args) throws InterruptedException {
        Random r=new Random();
        for(int i=0;i< nums.length;i++) nums[i]=50;
        Thread t1=new Thread(()-> {
            for (int i = 0; i < nums.length; i += 2) e1 += nums[i];
        });
        Thread t2=new Thread(()->{
            for(int i=1;i<nums.length;i+=2) e2+=nums[i];
        });
        long startTime = System.currentTimeMillis();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long endTime = System.currentTimeMillis();
        System.out.println(e1+e2);
        System.out.println(endTime - startTime);
    }
//    public static void main(String[] args) throws InterruptedException {
//        for(int i=0;i< nums.length;i++) nums[i]=50;
//        long startTime=System.currentTimeMillis();
//        int sum=0;
//        for(int i=0;i<nums.length;i++) sum+=nums[i];
//        long endTime=System.currentTimeMillis();
//        System.out.println(sum);
//        System.out.println(endTime - startTime);
//    }
}
