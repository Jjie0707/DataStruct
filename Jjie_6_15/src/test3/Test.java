package test3;

public class Test {
    public static int minOperations(int[] nums, int x) {
        int ret=0;
        int total=0;
        int length=nums.length;
        for(int i=0;i<length;i++){
            total+=nums[i];
        }
        int target=total-x;
        int left=0,right=0;
        int sum=0;
        for(;right<length;right++){
            sum+=nums[right];
            while(sum>target){
                sum-=nums[left];
                left++;
            }
            if(sum==target){
                ret=Math.max(ret,right-left+1);
            }
        }
        return ret;
    }
}
