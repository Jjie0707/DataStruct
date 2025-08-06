package test0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Q1 {
//    1,1,1
    public static void main(String[] args) {
        int[] nums={1,1,1};
        int k=2;
        System.out.println(subarraySum(nums, k));
    }
//    public static  int subarraySum(int[] nums, int k) {
//        int ans=0;
//        for(int l=0;l<nums.length;l++){
//            int sum=0;
//            for(int r=l;r<nums.length;r++){
//                sum+=nums[r];
//                if(sum==k) {
//                    ans++;
//                }
//            }
//        }'

//        return ans;
//    }
    public static  int subarraySum(int[] nums, int k) {

        int ans=0;
        int[] pres=new int[nums.length+1];
        HashMap<Integer, ArrayList<Integer>> m=new HashMap<>();

        int pre=0;
        pres[0]=0;
        ArrayList<Integer> list=new ArrayList<>();
        list.add(0);
        m.put(pre,list);
        for(int i=0;i<nums.length;i++){
            pre+=nums[i];
            pres[i+1]=pre;
            ArrayList<Integer> tem=m.get(pre);
            if(tem==null){
                tem=new ArrayList<>();
                tem.add(i+1);
                m.put(pre,tem);
            }else{
                tem.add(i+1);
            }
        }

        ArrayList<Integer> tem;
        for(int cur:m.keySet()){
            int target=cur-k;
            tem=m.get(target);
            if(tem!=null){
                for(int i:m.get(cur)){
                    for(int x:tem){
                        if(x<i) ans++;
                    }
                }
            }
        }
        return ans;
    }
}
