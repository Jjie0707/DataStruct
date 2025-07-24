package test0;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
//        int[] nums={0,3,7,2,5,8,4,6,0,1};
        int[] nums={1,0,1,2};
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        int ret=0;
        int len=1;
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]+1){
                ret=Math.max(len,ret);
                len=1;
            }else len++;
        }
        ret=Math.max(ret,len);
        return ret;
    }
}
