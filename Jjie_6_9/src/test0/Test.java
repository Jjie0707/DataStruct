package test0;

import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        int n=100,k=10;
        System.out.println(findKthNumber(n, k));
    }


    public static class Tem{
        public int count=0;
    }
    public static long func(Tem test,int i,int n,int k){
        if(i>n){
            return -1;
        }else{
            test.count++;
            if(test.count==k){
                return i;
            }else{
                long tem=0;
                if(i*10>n){
                    return -1;
                }
                for(int j=0;j<=9;j++){
                    tem=func(test,i*10+j,n,k);
                    if(tem!=-1){
                        return tem;
                    }
                }
                return -1;
            }
        }
    }
    public static int findKthNumber(int n, int k) {
        long tem=0;
        Tem test=new Tem();
        for(int i=1;i<=9;i++){
            tem=func(test,i,n,k);
            if(tem!=-1){
                break;
            }
        }
        return (int)tem;
    }


    //    暴力
    public static int findKthNumber_(int n, int k) {
        PriorityQueue<String> heap=new PriorityQueue<>((e1,e2)->e2.compareTo(e1));
        for(int i=1;i<=k;i++){
            heap.add(i+"");
        }
        for(int i=k+1;i<=n;i++){
            if(heap.peek().compareTo(i+"")>0){
                heap.poll();
                heap.add(i+"");
            }
        }
        return Integer.parseInt(heap.peek());
    }
}
