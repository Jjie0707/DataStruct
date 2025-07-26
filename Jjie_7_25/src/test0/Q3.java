package test0;

import java.util.*;

public class Q3 {
//        wǒ xǐ huān nǐ
    public static void main(String[] args) {
        int[] nums= {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set=new HashSet<>();
        for(int i=0;i+2<nums.length;i++){
            if(i-1>0 && nums[i]==nums[i-1]) continue;
            int left=i+1,right=nums.length-1;
            int target=-nums[i];
            List<Integer> tem;
            while(left<right){
                if(nums[left]+nums[right]>target) right--;
                else if(nums[left]+nums[right]<target) left++;
                else {
                    tem=new ArrayList<>();
                    tem.add(nums[i]);
                    tem.add(nums[left]);
                    tem.add(nums[right]);
                    set.add(tem);
                    left++;
                    right--;
                }
            }

        }
        List<List<Integer>> ret=new ArrayList<>();
        ret.addAll(set);
        return ret;
    }
}
