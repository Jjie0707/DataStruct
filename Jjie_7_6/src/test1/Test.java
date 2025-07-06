package test1;

import java.util.ArrayList;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        int[] nums1={1, 1, 2, 2, 2, 3},nums2={1, 4, 5, 2, 5, 4};
        Test t=new Test(nums1,nums2);
        System.out.println(t.count(7));
        t.add(3,2);
        System.out.println(t.count(8));
        System.out.println(t.count(4));
    }


    private int[] nums1;
    private int[] nums2;
    private boolean flag=false;
    private HashMap<Integer,Integer> m;

    public Test(int[] nums1, int[] nums2) {
        this.nums1=nums1;
        this.nums2=nums2;
        init();
    }

    public void add(int index, int val) {
        int pre=nums2[index];
        this.m.put(pre,this.m.get(pre)-1);
        nums2[index]+=val;
        pre+=val;
        if(this.m.get(pre)==null) this.m.put(pre,1);
        else this.m.put(pre,this.m.get(pre)+1);
    }

    public int count(int tot) {
        int ret=0;
        int target;
        for(int i=0;i<nums1.length;i++){
            Integer tem=this.m.get(tot-nums1[i]);
            ret+=(tem==null ? 0 :tem);
        }
        return ret;
    }
    private void init(){
        if(!this.flag){
            this.m=new HashMap<>();
            for(int x:this.nums2){
                if(this.m.get(x)==null)  this.m.put(x,1);
                else this.m.put(x,this.m.get(x)+1);
            }
            this.flag=true;
        }
    }
}
