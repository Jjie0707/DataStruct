package test2;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] nums={2,2,3,4};
        System.out.println(triangleNumber(nums));
    }
    public static int triangleNumber(int[] nums) {
        int length=nums.length;
        int ret=0;
        Arrays.sort(nums);
        for(int i=length-1;i>=2;i--){
            int left=0;
            int right=i-1;
            int c=nums[i];
            while(left<right){
                if(nums[left]+nums[right]>c){
                    ret+=(right-left);
                    right--;
                }else{
                    left++;
                }
            }
        }
        return ret;
    }
}
