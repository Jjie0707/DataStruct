package test3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[] nums= {1, 0, -1, 0, -2, 2};
        int target=0;
        System.out.println(fourSum(nums,target));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        int length=nums.length;
        for(int i=0;i<length-3;i++){
            //对于i去重
            if((i>0 && i<length-3) && nums[i]==nums[i-1]) i++;
            int key=target-nums[i];
            //只有target大于等于0才有继续的意义
            if(target>=0){
                for(int j=i+1;j<length-2;j++){
                    while( (j>i+1 && j<length-2) && nums[j]==nums[j-1]) j++;
                    //对于j的去重
                    int tem=key-nums[j];
                    int left=j+1;
                    int right=length-1;
                    while(left<right){
                        int e1=nums[left];
                        int e2=nums[right];
                        if(e1+e2>tem) right--;
                        else if(e1+e2<tem) left++;
                        else{
                            ArrayList<Integer> list=new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(e1);
                            list.add(e2);
                            ans.add(list);
                            left++;
                            right--;
                            while(left<right && nums[left]==nums[left-1]) left++;
                            while(left<right && nums[right]==nums[right-1]) right--;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
