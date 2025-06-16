package test0;

import java.util.Arrays;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        int[] nums={3,2,4};
        int target=6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
    public static int[] twoSum(int[] nums, int target) {
        int length=nums.length;
        int[][] arr=new int[length][2];
        for(int i=0;i<nums.length;i++){
            arr[i][0]=nums[i];
            arr[i][1]=i;
        }
        int[] ret=new int[2];
        int left=0,right=length-1;
        Arrays.sort(arr,(e1,e2)->e1[0]-e2[0]);
        while(left<right){
            int tem=arr[left][0]+arr[right][0];
            if(tem<target){
                left++;
            }else if(tem>target){
                right--;
            }else{
                ret[0]=arr[left][1];
                ret[1]=arr[right][1];
                break;
            }
        }
        return ret;
    }
}
