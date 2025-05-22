package test0;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] nums={34,25,63,126,4767,234,78,43,32,25,34};
        System.out.println(Arrays.toString(nums));
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void quickSort(int[] nums){
        quickSort(nums,0,nums.length-1);
    }
    public static void quickSort(int[] nums,int start,int end){
        if(start>=end){
            return ;
        }
        int pit=pit(nums,start,end);
        quickSort(nums,start,pit-1);
        quickSort(nums,pit+1,end);
    }
    public static void swap(int[] nums,int e1,int e2){
        int tem=nums[e1];
        nums[e1]=nums[e2];
        nums[e2]=tem;
    }
    public static void getMid(int[] nums,int start,int end){
        int mid=(start+end)/2;
        if(nums[start]>nums[end]){
            if(nums[end]>nums[mid]){
                swap(nums,start,end);
            }else if(nums[start]>nums[mid]){
                swap(nums,mid,start);
            }else{
                return ;
            }
        }else{
            //nums[start]<=nums[end]
            if(nums[start]>nums[mid]){
                return ;
            }else if(nums[end]>nums[mid]){
                swap(nums,mid,start);
            }else{
                swap(nums,start,end);
            }
        }
    }
    // hoare法
    public static int pit0(int[] nums,int start,int end){
        getMid(nums,start,end);
        int key=nums[start];
        int left=start;
        int right=end;
        while(left<right){
            while(left<right && nums[right]>=key){
                right--;
            }
            while(left<right && nums[left]<=key){
                left++;
            }
            swap(nums,left,right);
        }
        swap(nums,start,left);
        return left;
    }
    //挖坑法
    public static int pit1(int[] nums,int start,int end){
        int key=nums[start];
        int left=start;
        int right=end;
        while(left<right){
            while(left<right && nums[right]>=key ){
                right--;
            }
            nums[left]=nums[right];
            while(left<right && nums[left]<=key){
                left++;
            }
            nums[right]=nums[left];
        }
        nums[left]=key;
        return left;
    }
    public static int pit(int[] nums,int start,int end){
        return 0;
    }
}
