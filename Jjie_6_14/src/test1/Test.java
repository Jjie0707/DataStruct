package test1;

public class Test {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        int ret = 0;
        int left = 0, right = 0, sum = nums[0];
        while (right < length) {
            while (right < length && sum < target) {
                right++;
                if(right<length) {
                    sum += nums[right];
                }else{
                    break;
                }
            }
            while (right<length && left < right && sum >= target) {
                if (ret == 0) {
                    ret = right - left + 1;
                } else if (right - left + 1 < ret) {
                    ret=right-left+1;
                }
                sum-=nums[left];
                left++;
            }
        }
        return ret;
    }
}
