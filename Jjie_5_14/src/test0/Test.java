package test0;

import java.util.Arrays;

public class Test {
    public static void insertSort(int[] nums){
        int length=nums.length;
        for(int i=0;i<length;i++){
            int j=i-1;
            int tem=nums[i];
            while(j>=0){
                if(nums[j]>tem){
                    nums[j+1]=nums[j];
                    j--;
                }else{
                    break;
                }
            }
            nums[j+1]=tem;
        }
    }
    public static void shellSort(int[] nums){
        int length=nums.length;
        int gap=length;
        while(gap>=1){
            for(int i=0;i<length;i+=1){
                int j=i-gap;
                int tem=nums[i];
                while(j>=0){
                    if(nums[j]>tem){
                        nums[j+gap]=nums[j];
                        j-=gap;
                    }else{
                        break;
                    }
                    nums[j+gap]=tem;
                }
            }
            gap/=2;
        }
    }
    public static void main(String[] args) {
        int[] arr={64,2,3,6,2,5,8,2,85,24,73,77};
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
//        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
