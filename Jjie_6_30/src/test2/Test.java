package test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        int[] nums = {-16,-13,8,16,35,-17,30,-8,34,-2,-29,-35,15,13,-30,-34,6,15,28,-23,34,28,-24,15,-17,10,31,32,-3,-36,19,31,-5,-21,-33,-18,-23,-37,-15,12,-28,-40,1,38,38,-38,33,-35,-28,-40,4,-15,-29,-33,-18,-9,-29,20,1,36,-8,23,-34,16,-7,13,39,38,7,-7,-10,30,9,26,27,-37,-18,-25,14,-36,23,28,-15,35,-9,1};
        int k=8;
        System.out.println(Arrays.toString(maxSubsequence(nums, k)));
    }

    public static int[] maxSubsequence(int[] nums, int k) {
//        int ret=0;
//        PriorityQueue<Integer> heap=new PriorityQueue<>();
//        for(int i=0;i<nums.length;i++){
//            if(heap.size()<k){
//                ret+=nums[i];
//                heap.offer(nums[i]);
//            }else{
//                if(heap.peek()<nums[i]){
//                    ret-=heap.poll();
//                    ret+=nums[i];
//                    heap.offer(nums[i]);
//                }
//            }
//        }
        int[] ret=new int[k];
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            if(heap.size()<k){
                heap.offer(nums[i]);
                list.add(nums[i]);
            }else{
                if(nums[i]>heap.peek()){
                    Integer tem=heap.poll();
                    list.remove(tem);
                    heap.offer(nums[i]);
                    list.add(nums[i]);
                }
            }
        }
        int i=0;
        for(int x:list){
            ret[i++]=x;
        }
        return ret;
    }
}
