package test0;

import java.util.HashSet;
import java.util.Set;

public class Q1 {
    public static void main(String[] args) {
        int[] nums = {4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
        System.out.println(longestConsecutive(nums));
    }



    public static int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        int ret = 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int x : set) {
            if (set.contains(x - 1)) continue;
            int len = 1;
            while (set.contains(++x)) len++;
            ret = Math.max(ret, len);
        }
        return ret;
    }
}
