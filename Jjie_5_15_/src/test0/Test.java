package test0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Test {
    public static void sort(int[] nums){
        int length=nums.length;
        sort(nums,0,length);
    }
    public static void sort(int[] nums,int start,int end){
        if(start>=end){
            return ;
        }
        int key=nums[start];
        int left=start+1;
        int right=end;
        while(left<right){
            while(left<right && nums[right]>=key){

            }
        }
    }



    public static void quickSort(int[] nums){
        quickSort(nums,0,nums.length-1);
    }
    public static void quickSort(int[] nums,int start,int end){
        if(start>=end ){
            return ;
        }
        int pit=start;
        int key=nums[start];
        int left=start;
        int right=end;
        while(left<right){
            while(left<right && nums[right]>=key){
                right--;
            }if(left>right){
                break;
            }
            nums[pit]=nums[right];
            pit=right;
            while(left<right && nums[left]<=key){
                left++;
            }if(left>right){
                break;
            }
            nums[pit]=nums[left];
            pit=left;
        }
        nums[pit]=key;
        Stack<ArrayList> s=new Stack<>();
        ArrayList<Integer> list=new ArrayList<>();
        list.add(start);
        list.add(pit-1);

        s.push(list);
        list=new ArrayList<>();
        list.add(pit+1);
        list.add(end);
        while(!s.isEmpty()){
            ArrayList<Integer> tem=s.pop();

        }
    }

    public static void main(String[] args) {
        int[] nums={2,4,1,6,2,6,9,2,87};
        System.out.println(Arrays.toString(nums));
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
