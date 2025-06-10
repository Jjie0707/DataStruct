package test0;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        int[] nums={2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10};
        List<List<Integer>> list =threeSum(nums);
        System.out.println(list);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        Arrays.sort(nums);

        int length =nums.length;

        for(int i=0;i<length-2;i++){

            int key=nums[i];
            int left=i+1;
            int right=length-1;
            if(key<=0 && !set.contains(key)){
                HashSet<Integer> tem=new HashSet<>();
                while(left<right){
                    ArrayList<Integer> list=new ArrayList<>();
                    list.add(key);
                    int e1=nums[left];
                    int e2=nums[right];
                    if(e1+e2>-key){
                        right--;
                    }else if(e1+e2<-key){
                        left++;
                    }else{
                        //走到这里e1+e2=-key
                        if(!tem.contains(e1) && !tem.contains(e2)){
                            list.add(e1);
                            list.add(e2);
                            tem.add(e1);
                            tem.add(e2);
                            ans.add(list);
                            set.add(key);
                        }
                        left++;
                        right--;
                    }
                }
            }

        }
        return ans;
    }
}
