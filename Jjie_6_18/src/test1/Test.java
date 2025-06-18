package test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
//        int[] nums={4,2,9,8,2,12,7,12,10,5,8,5,5,7,9,2,5,11};
        int[] nums={2,4,2,2,5,2};
        int[][] tem=divideArray(nums, 2);
        for(int[] arr:tem){
            System.out.print(Arrays.toString(arr)+" ");
        }
    }
    public static int[][] divideArray(int[] nums, int k) {
        int length=nums.length;
        int[][] ans=new int[length/3][3];
        int j=0;
        int left=0;
        Arrays.sort(nums);
        for(;left+2<length;left+=3){
            int min=Math.min(nums[left],Math.min(nums[left+1],nums[left+2]));
            int max=Math.max(nums[left],Math.max(nums[left+1],nums[left+2]));
            if(max-min<=k){
                ans[j++]=Arrays.copyOfRange(nums,left,left+3);
            }else{
                return new int[0][3];
            }
        }
        return ans;
    }
//    public static int[][] divideArray(int[] nums, int k) {
//        ArrayList<int[]> ret=new ArrayList<>();
//        int length=nums.length;
//        PriorityQueue<Integer> heap=new PriorityQueue<>();
//        heap.offer(length-1);
//        heap.offer(length/3-1);
//        heap.offer(length*2/3-1);
//        Arrays.sort(nums);
//        int left=0,right=0;
//        int min=nums[left];
//        int max=nums[left];
//        while(right<length){
//            if(nums[right]<min){
//                min=nums[right];
//            }else if(nums[right]>max){
//                max=nums[right];
//            }
//            if(heap.peek()==right){
//                if(max-min<=k){
//                    ret.add( Arrays.copyOfRange(nums, left,right+1));
//                }
//                left=right+1;
//                if(left<length) {
//                    min = nums[left];
//                    max = nums[left];
//                }
//                heap.poll();
//            }
//            right++;
//        }
//        int[][] ans=new int[ret.size()][];
//        for(int i=0;i<ans.length;i++){
//            ans[i]=ret.get(i);
//        }
//        return ans;
//    }

}
