package test0;

public class Test {
    public static void main(String[] args) {
        int[] arr = {3,1,4,3,2,2,4};
        int k = 2;
        System.out.println(Solution.countGood(arr, k));
    }

    class Solution {
<<<<<<< HEAD
//        public static boolean check(int[] arr, int start, int end, int k) {
//            int count = 0;
//            for (int i = start; i <= end; i++) {
//                for (int j = i + 1; j <= end; j++) {
//                    if (arr[i] == arr[j]) {
//                        count++;
//                    }
//                    if (count >= k) {
//                        return true;
//                    }
//                }
//            }
//            return count == k;
//        }
=======
        class Solution {
        public static boolean check2(int[] arr, int start, int end, int k) {
            int count = 0;
            for (int i = start; i <= end; i++) {
                for (int j = i + 1; j <= end; j++) {
                    if (arr[i] == arr[j]) {
                        count++;
                    }
                    if (count >= k) {
                        return true;
                    }
                }
            }
            return count == k;
            
>>>>>>> test
        public static boolean check(int[] arr, int start, int end, int k) {
            int count = 0;
            for (int i = start; i <= end; i++) {
                for (int j = i + 1; j <= end; j++) {
                    if (arr[i] == arr[j]) {
                        count++;
                    }
                    if (count >= k) {
                        return true;
                    }
                }
            }
            return count == k;
        }

        public static long countGood(int[] nums, int k) {
            long res = 0;

            int length = 2;
            while (true) {
                if ((length * (length - 1) >= 2 * k)) {
                    break;
                }
                length++;
            }
            int left = 0;
            int right = left + length - 1;

            int end = nums.length - 1;
            if (right > end) {
                return res;
            }
            //不断移动右边界直到成为好数组
            for(int i=0;i+length-1<=end;i++){
                //length是要达到k好数组的最小长度
                left=i;
                right= left + length - 1;
                if(right>end){
                    continue;
                }
                while (right+1<=end && !check(nums, left, right, k)) {
                    right++;
                }
                if(check(nums,left,right,k)) {
                    res += (end - right + 1);
                }
            }
            return res;
        }
    }
}
