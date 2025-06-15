package test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        int[] nums={2,1,2,2,5};
        int p=2;
        System.out.println(minimizeMax(nums, p));
    }
    public static int minimizeMax(int[] nums, int p) {
        if(p==0){
            return 0;
        }
        Arrays.sort(nums);
        int length=nums.length;
        PriorityQueue<Integer> heap=new PriorityQueue<>((e1, e2)->e2-e1);
        PriorityQueue<Integer> rest=new PriorityQueue<>((e1,e2)->e2-e1);
        int count=0;
        int i=0;
        for(;i<length-2;i++){
            if(Math.abs(nums[i]-nums[i+1])<=(Math.abs(nums[i+1]-nums[i+2]))){
                //说明对于i+1来说i是最好的选择
                //此时要看看rest中是否有更好的选择
                int tem=Math.abs(nums[i]-nums[i+1]);
                if(!rest.isEmpty()){
                    if(Math.abs(nums[i]-rest.peek())<=tem){
                        tem=Math.abs(nums[i]-rest.peek());
                        //如果rest里面有更好的选择就用
                        rest.poll();
                    }else{
                        i++;
                    }
                }else{
                    //如果没有更好的选择，就用i+1,表示不用再处理i+1
                    i++;
                }
                if(count<p){
                    heap.offer(tem);
                    count++;
                }else{
                    if(heap.peek()>tem){
                        heap.poll();
                        heap.offer(tem);
                    }
                }
            }else{
                if(!rest.isEmpty()){
                    int tem=Math.abs(rest.poll()-nums[i]);
                    if(count<p){
                        heap.offer(tem);
                        count++;
                    }else{
                        if(heap.peek()>tem){
                            heap.poll();
                            heap.offer(tem);
                        }
                    }
                }else{
                    rest.offer(nums[i]);
                }
            }
        }
        for(;i<length;i++){
            rest.offer(nums[i]);
        }
//        这是对于剩下的数的处理,但只处理了一次，明显不合理
//        if(rest.size()>1){
//            int tem=Math.abs(rest.poll()-rest.poll());
//            if(count<p){
//                heap.offer(tem);
//                count++;
//            }else{
//                if(heap.peek()>tem){
//                    heap.poll();
//                    heap.offer(tem);
//                }
//            }
//        }

        /**
         * 由于剩下的元素不可能很多，我们可以用暴力的方法解决
         */
        //剩余元素数量大于1才处理
        if(rest.size()>1){
            ArrayList<Integer> list=new ArrayList<>();
            while(!rest.isEmpty()){
                list.add(rest.poll());
            }
            while(list.size()>1){
                int[] arr =new int[list.size()-1];
                int minindex=0;
                int min=Integer.MAX_VALUE;
                for(int j=0;j<arr.length;j++){
                    arr[j]=Math.abs(list.get(j)-list.get(j+1));
                    if(arr[j]<min){
                        min=arr[j];
                        minindex=j;
                    }
                }
                list.remove(minindex);
                list.remove(minindex);
                if(count<p){
                    heap.offer(min);
                    count++;
                }else{
                    if(heap.peek()>min){
                        heap.poll();
                        heap.offer(min);
                    }
                }
            }
        }
        return heap.peek();
    }
}
