package test1;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] nums={4,3,8,9,0,5,20,14,7,1,2,15,4,4};
        System.out.println(Arrays.toString(nums));
        countSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void countSort(int[] nums){
        int length=nums.length;
        int max=nums[0];
        int min=nums[0];
        for(int i=0;i<length;i++){
            if(nums[i]>max){
                max=nums[i];
            }
            if(nums[i]<min){
                min=nums[i];
            }
        }
        //走到这里找到了最值
        int[] tem=new int[max-min+1];
        for(int i=0;i<length;i++){
            tem[nums[i]-min]++;
        }
        int j=0;
        for(int i=0;i<tem.length;i++){
            while(tem[i]!=0){
                nums[j++]=i+min;
                tem[i]--;
            }
        }
    }

}
