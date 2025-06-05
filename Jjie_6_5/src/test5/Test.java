package test5;

import java.util.ArrayList;

public class Test {
    public static int maxArea(int[] height) {
        ArrayList<Integer> list=new ArrayList<>();
        int ret=0;
        int left=0;
        int right=height.length-1;
        while(left<right){
            int v=Math.min(height[left],height[right])*(right-left);
            list.add(v);
            if(height[left]<=height[right]){
                left++;
            }else{
                right--;
            }
        }
        for(int tem:list){
            if(tem>ret){
                ret=tem;
            }
        }
        return ret;
    }
}
