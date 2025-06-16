package test0;

public class Test {
    public static int minSubArrayLen(int target, int[] nums) {
        int ret=Integer.MAX_VALUE;
        int length=nums.length,sum=0;
        for(int left=0,right=0;right<length;right++){
            sum+=nums[left];
            while(sum>=target){
                ret=Math.min(ret,right-left+1);
                sum-=nums[left];
                left++;
            }
        }
        return ret==Integer.MAX_VALUE ? 0 :ret;
    }
}
