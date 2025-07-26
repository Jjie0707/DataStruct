package test0;

import java.util.Arrays;

public class Q2 {
    public static void main(String[] args) {
        int[] nums={0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void moveZeroes(int[] nums) {
        int left=-1,right=0;
        for(;right<nums.length;right++){
            if(right!=0) swap(nums,++left,right);
        }
    }
    private static void swap(int[] nums,int e1,int e2){
        int  tem=nums[e1];
        nums[e1]=nums[e2];
        nums[e2]=tem;
    }
}
