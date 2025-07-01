package test2;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        System.out.println(findLHS(nums));
    }
    public static int findLHS(int[] nums) {
        Arrays.sort(nums);
        int ret=0,left=0;
        int min=nums[left],max=0;
        for(int right=0;right<nums.length;right++){
            max=nums[right];
            while(max-min>1){
                left++;
                min=nums[left];
            }
            if(max-min==1) ret=Math.max(ret,right-left+1);
        }
        return ret;
    }
}
