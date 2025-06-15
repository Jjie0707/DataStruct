package test1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        int[] nums={10,1,2,7,1,3};
        int p=1;
        System.out.println(minimizeMax(nums, p));
    }
    public static int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int length=nums.length;
        PriorityQueue<Integer> heap=new PriorityQueue<>((e1,e2)->e2-e1);
        PriorityQueue<Integer> un=new PriorityQueue<>((e1,e2)->e2-e1);
        //堆顶是p个差值的最大值，要保证他尽量小
        //也就是topk的问题
        int count=0;
        int i=0;
        for(;i+2<length;i++){
            if(count<p){
                if(Math.abs(nums[i]-nums[i+1])<(Math.abs(nums[i+1]-nums[i+2]))){
                    int tem1=Math.abs(nums[i]-nums[i+1]);
                    if(!un.isEmpty()){
                        int tem=Math.abs(un.peek()-nums[i]);
                        if(tem<tem1){
                            heap.offer(tem);
                            un.poll();
                        }else{
                            heap.offer(tem1);
                        }
                    }else{
                        heap.offer(tem1);
                        i++;
                    }
                }else{
                    if(!un.isEmpty()){
                        heap.offer(Math.abs(un.poll()-nums[i]));
                    }else{
                        un.offer(nums[i]);
                    }
                }
                count++;
            }else{
                if(Math.abs(nums[i]-nums[i+1])<(Math.abs(nums[i+1]-nums[i+2]))){
                    int tem1=Math.abs(nums[i]-nums[i+1]);
                    if(!un.isEmpty()){
                        int tem=Math.abs(un.peek()-nums[i]);
                        if(tem<tem1){
                            un.poll();
                            if(heap.peek()>tem){
                                heap.poll();
                                heap.offer(tem);
                            }
                        }else{
                            if(heap.peek()>tem){
                                heap.poll();
                                heap.offer(tem1);
                            }
                        }
                    }else{
                        if(heap.peek()>tem1){
                            heap.poll();
                            heap.offer(tem1);
                        }
                        i++;
                    }
                }
            }
        }
        for(;i<length;i++){

        }
        return heap.peek();
    }
}
