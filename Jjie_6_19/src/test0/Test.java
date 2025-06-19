package test0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        int[] nums={15,17,5,8,16,19,13,6,17,6};
        int k=9;
        System.out.println(partitionArray(nums, k));
    }
    public static int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ret=0;
        int l=0;
        for(int r=0;r<nums.length;r++){
            if(nums[l]+k<nums[r]){
                ret++;
                l=r;
            }
        }
        if(nums[nums.length-1]-nums[l]<=k){
            ret++;
        }
        return ret;
    }
//    public static int partitionArray(int[] nums, int k) {
//        ArrayList<PriorityQueue<Integer>> ans=new ArrayList<>();
//        for(int i=0;i<nums.length;i++){
//            if(ans.isEmpty()){
//                PriorityQueue<Integer> tem=new PriorityQueue<>((e1,e2)->e1-e2);
//                tem.offer(nums[i]);
//                ans.add(tem);
//            }else{
//                boolean flag=true;
//                for(int j=0;j<ans.size();j++){
//                    PriorityQueue<Integer> tem=ans.get(j);
//                    if(Math.abs(tem.peek()-nums[i])<=k){
//                        tem.offer(nums[i]);
//                        flag=false;
//                        break;
//                    }
//                }
//                //走到这里一定是没有符合条件的
//                if(flag) {
//                    PriorityQueue<Integer> tem = new PriorityQueue<>();
//                    tem.offer(nums[i]);
//                    ans.add(tem);
//                }
//            }
//        }
//        return ans.size();
//    }

}
