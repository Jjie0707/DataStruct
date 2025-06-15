package test3;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] nums={10,1,2,7,1,3};
        int p=2;
        System.out.println(minimizeMax(nums, p));
    }
    public static int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int length=nums.length;
        int left=-1;
        int right=nums[length-1]-nums[0];
        while(left+1<right){
            int mid=(left+right)>>1;
            if(check(nums,mid,p)){
                right=mid;
            }else{
                left=mid;
            }
        }
        return right;
    }
    public static boolean check(int[] nums,int mid,int p){
        int length=nums.length;
        int count=0,i=0;
        while(i<length-1){
            if(Math.abs(nums[i]-nums[i+1])<=mid){
                i+=2;
                count++;
            }else{
                i++;
            }
        }
        return count>=p;
    }
}
