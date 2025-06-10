package test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class test {
    public static void main(String[] args) {
        int[] nums={2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10};
        List<List<Integer>> list = threeSum(nums);
        System.out.println(list);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        int length = nums.length;

        for (int i = 0; i < length - 2; i++) {
            while(i>0 && nums[i]==nums[i-1]){
                i++;
            }
            //对于i的去重

            int key = -nums[i];
            int left = i + 1;
            int right = length - 1;
            if(key>=0){
                while(left<right){
                    ArrayList<Integer> list=new ArrayList<>();
                    list.add(-key);
                    int e1=nums[left];
                    int e2=nums[right];
                    if(e1+e2>key) right--;
                    else if(e1+e2<key) left++;
                    else{
                        list.add(e1);
                        list.add(e2);
                        left++;right--;
                        while(left<right && nums[left]==nums[left-1]) left++;
                        while(left<right && nums[right]==nums[right+1]) right--;
                        ans.add(list);
                    }
                }
            }
        }
        return ans;
    }
}

