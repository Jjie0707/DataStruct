package test0;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] nums={2,9,4,3,6,9,1,1};
        int target=6;
        System.out.println(numSubseq(nums, target));
    }
    public static int func(int[] nums,int target,int start){
        int right = nums.length - 1;
        int left = start;
        int ret=left;
        if (nums[left] + nums[right] <= target) {
            return right;
        } else {
            while (left <=right) {
                int mid = (left + right)/2;
                if (nums[start] + nums[mid] <= target) {
                    ret=mid;
                    left = mid+1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return ret;
    }
    public static int numSubseq(int[] nums, int target) {
        int ret=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]*2>target){
                break;
            }
            int end=func(nums,target,i);
            ret+=Math.pow(2,end-i);
        }
        return ret%1000000007;
    }
}
