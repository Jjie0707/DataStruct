package test1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class Test {
    public static void main(String[] args) {
        int[] nums={3,4,9,1,3,9,5};
        int k=1;
        int key=9;
        System.out.println(findKDistantIndices(nums, key, k));
    }
    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        ArrayList<Integer> ret=new ArrayList<>();//返回答案
        ArrayList<Integer> tem=new ArrayList<>();//所有key对应的下标
        for(int i=0;i<nums.length;i++){
            if(nums[i]==key){
                tem.add(i);
            }
        }
        if(tem.size()==nums.length){
            return tem;
        }
        for(int i=0;i<tem.size();i++){
            int d=tem.get(i);
            for(int j=Math.max(0,d-k);j<=Math.min(nums.length-1,d+k);j++){
                if(!ret.contains(j)){
                    ret.add(j);
                }
            }
        }
        return ret;
    }
}
