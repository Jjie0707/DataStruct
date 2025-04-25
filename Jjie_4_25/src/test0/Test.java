package test0;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(3);
        arr.add(2);
        arr.add(4);

        int m=2;
        int k=1;
        System.out.println(countInterestingSubarrays(arr,m,k));
    }
    public static long countInterestingSubarrays(List<Integer> nums, int m, int k) {
        int length= nums.size();

        int[] arr=new int[length];
        for(int i=0;i<length;i++){
            arr[i]=nums.get(i) % m;
        }

        int count=0;
        int[] pre=new int[length];
        for(int i=0;i<length;i++){
            if(arr[i]==k){
                count++;
            }
            pre[i]=count;
        }
        //完成了前缀和的统计

        int ret=0;
        for(int i=0;i<length;i++){
            if(k==0 && arr[i]!=k){
                ret++;
                continue;
            } else if (k==1 && arr[i]==k) {
                ret++;
                continue;
            }
            if(pre[i]%m==k){
                ret++;
            }
        }
        return ret;
    }
    public static void main1(String[] args) {
        System.out.println("hello world");
    }

    public static void main0(String[] args) {
        MinStack s = new MinStack();
        s.push(1);
        s.push(3);
        s.push(9);
        s.push(7);
        s.push(5);
        s.push(5);
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.push(9999);
        System.out.println(s.top());
//        List
    }
}
/*
class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int m, int k) {
        int length= nums.size();

        int[] arr=new int[length];
        for(int i=0;i<length;i++){
            arr[i]=nums.get(i) % m;
        }

        int count=0;
        int[] pre=new int[length];
        for(int i=0;i<length;i++){
            if(arr[i]==k){
                count++;
            }
            pre[i]=count;
        }
        //完成了前缀和的统计

        int ret=0;
        for(int i=0;i<length;i++){

        }
        return ret;
    }
}
 */