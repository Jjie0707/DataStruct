package test2;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] nums={7,1,5,4};
        System.out.println(maximumDifference(nums));
    }
    public static int maximumDifference(int[] nums) {
        int ret=Integer.MIN_VALUE;
        int length=nums.length;
        int[][] arr=new int[length][2];
        Arrays.sort(arr,(e1,e2)->e1[0]-e2[0]);
        for(int i=0;i<length;i++){
            arr[i][0]=nums[i];
            arr[i][1]=i;
        }
        for(int i=0;i<length;i++){
            int left=i,right=length-1;
            while(left<right){
                if(arr[left][1]<arr[right][1] && ret<arr[right][0]-arr[left][0]){
                    ret=arr[right][0]-arr[left][0];
                }
                right--;
            }
        }
        return ret==Integer.MIN_VALUE ? -1 : ret;
    }
}
