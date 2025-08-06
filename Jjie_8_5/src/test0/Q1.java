package test0;

import java.util.ArrayList;
import java.util.HashMap;

public class Q1 {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        int k=3;
        System.out.println(subarraySum(nums, k));
    }
    public static int subarraySum(int[] nums, int k) {
        int ans=0;
        int pre=0;
        int[] pres=new int[nums.length+1];
        HashMap<Integer, ArrayList<Integer>> m=new HashMap<>();

        for(int i=1;i<pres.length;i++){
            pre+=nums[i-1];
            pres[i]=pre;
        }

        for(int i=0;i<pres.length;i++){
            int target=pres[i]-k;
            ArrayList<Integer> tem=m.get(target);
            if(tem!=null) ans+=tem.size();

            int cur=pres[i];
            ArrayList<Integer> list=new ArrayList<>();
            list.add(i);
            if(!m.containsKey(cur)) m.put(cur,list);
            else m.get(cur).add(i);
        }
        return ans;
    }
}
