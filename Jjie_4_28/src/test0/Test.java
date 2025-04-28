package test0;

public class Test {
    public static void main(String[] args) {
        int[] nums={9,5,3,8,4,7,2,7,4,5,4,9,1,4,8,10,8,10,4,7};
        long k=4;
        int[] nums2={100000, 100000, 1, 100000};
        System.out.println(countSubarrays(nums, k));
        System.out.println(countSubarrays(nums2, 100000));
    }
    public static boolean func(int[] nums, int left, int right, long k) {
        int length = right-left+1;
        int sum = 0;
        for (int i =0; i <length; i++) {
            sum += nums[left + i];
        }
        return sum * length < k;
        //这里数组的分数只要不是严格小于k就会return false
    }

    public static long countSubarrays(int[] nums, long k) {
        int length = nums.length;
        long total = (length+1) * length / 2;
        long count = 0;

        int left = 0;
        int right = 0;
        // while(!func(nums,left,right,k)){
        //     right++;
        // }
        while (true) {
            if(left>right){
                right++;
            }
            while (right + 1 < length && func(nums, left, right, k)) {
                right++;
            }
            //确保了right最多走到length-1
            //只要能走到这里说明数组现在是不满足条件i的 也就是分数大于等于k
            // 或者是right走到了length-1
            if (right == length - 1) {
                if (!(func(nums, left, right, k))) {
                    count++;
                    left++;
                    while (left <=right && !(func(nums, left, right, k))) {
                        count++;
                        left++;
                    }
                }
                break;
            }
            //其余非特殊情况
            count += (length - right);
            left++;
            while (left <= right && !(func(nums, left, right, k))) {
                count += (length - right);
                left++;
            }
        }
        return total - count;
    }
}
