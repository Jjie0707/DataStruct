package test1;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] nums={27,49,65,25,37,34,19,18,15,28};
        System.out.println(Arrays.toString(nums));
        adjustDown(nums);
        System.out.println(Arrays.toString(nums));

        int length=nums.length;
        nums=Arrays.copyOf(nums,length+1);
        nums[nums.length-1]=76;
        adjustUp(nums);
        System.out.println(Arrays.toString(nums));
    }
    //向下调整算法
    public static void adjustUp(int[] nums){

        int child=nums.length-1;
        while(child>0){
            int parent=(child-1)/2;
            if(nums[parent]<nums[child]){
                swap(nums,child,parent);
            }else{
                break;
            }
            child=parent;
        }
    }
    public static void adjustDown(int[] nums){
        int length=nums.length;
        for(int i=(length-1)/2;i>=0;i--){
            int parent=i;
            while(parent<length){
                int child=2*parent+1;
                if(child+1<length && nums[child]<nums[child+1]){
                    child++;
                }
                if(child>=length){
                    break;
                }
                if(nums[parent]<nums[child]){
                    swap(nums,child,parent);
                }
                parent=child;
            }
        }
    }
    public static void swap(int[] nums,int e1,int e2){
        int tem=nums[e1];
        nums[e1]=nums[e2];
        nums[e2]=tem;
    }
}
