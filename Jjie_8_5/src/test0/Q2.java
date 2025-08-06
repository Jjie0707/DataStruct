package test0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Q2 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
//        int[] nums={1};
//        int k=1;

        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    //    输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//    输出：[3,3,5,5,6,7]
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(k>=nums.length){
            int[] ret=new int[1];
            int max=nums[0];
            for(int i=0;i<nums.length;i++){
                if(nums[i]>max) max=nums[i];
            }
            ret[0]=max;
            return ret;
        }

        ArrayList<Integer> list=new ArrayList<>();
        PriorityQueue<Integer> heap=new PriorityQueue<>((e1,e2)->e2-e1);
        for(int i=0;i<k-1;i++){
            int cur=nums[i];
            heap.offer(cur);
        }
        for(int i=k-1;i<nums.length;i++){
            heap.offer(nums[i]);
            list.add(heap.peek());
            heap.remove(nums[i-(k-1)]);
        }
        int[] ret=new int[list.size()];
        for(int i=0;i<list.size();i++){
            ret[i]=list.get(i);
        }
        return ret;

    }
}
