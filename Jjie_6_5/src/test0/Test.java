package test0;

import java.util.Arrays;
//双指针法完成第一趟排序的快排
public class Test {
    public static void main(String[] args) {
        int[] nums={36,6,5,5,4,4,3,3,2,2,1,1};
        System.out.println(Arrays.toString(nums));
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void quickSort(int[] nums){
        quick(nums,0,nums.length-1);
    }
    public static void quick(int[] nums,int start,int end){
        if(start>=end){
            return;
        }
        int par=sort(nums,start,end);
        quick(nums,start,par-1);
        quick(nums,par+1,end);
    }
    public static int sort(int[] nums,int start,int end){
        int key=nums[start];
        int left=start;
        int right=start+1;
        while(right<=end){
            if(nums[right]<=key){
                left++;
                swap(nums,left,right);
            }
            right++;
        }
        swap(nums,start,left);
        return left;
    }
    public static void swap(int[] nums,int e1,int e2){
        int tem=nums[e1];
        nums[e1]=nums[e2];
        nums[e2]=tem;
    }
}
