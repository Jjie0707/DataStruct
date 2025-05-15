package test2;

import java.util.Stack;

public class Test {
    public static void quickSort(int[] nums){
        quickSort(nums,0,nums.length-1);
    }
    public static void quickSort(int[] nums,int start,int end){
        Stack<Integer> s=new Stack<>();
        s.add(start);
        s.add(end);
        while(!s.isEmpty()){
            int right=s.pop();
            int left=s.pop();
            int par=
        }
    }
}
