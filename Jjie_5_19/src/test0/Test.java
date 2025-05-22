package test0;

import java.util.Arrays;
import java.util.Stack;

public class Test {
    public static void main1(String[] args) {
//        int[] nums={1,2,3,4,5,6,7,8,9};
//        int[] nums={49,38,65,97,76,13,27,49};
//        int[] nums={9,8,7,6,5,4,3,2,1};
        int[] nums={1,0};
        System.out.println(Arrays.toString(nums));
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void mergeSort(int[] nums){
        mergeSortNon(nums,0,nums.length-1);
    }
    public static void mergeSortNon(int[] nums,int start,int end){
        int gap=1;
        while(gap<end-start+1){
            for(int i=0;i+gap<=end;i+=2*gap){
                int start1=i;
                int end1=start1+gap-1;
                int start2=i+gap;
                int end2=start2+gap-1;
                if(end2>end){
                    end2=end;
                }
                merge(nums,start1,start2,end1,end2);
            }
            gap*=2;
        }
    }
    public static void merge(int[] nums,int start1,int start2,int end1,int end2){
        int[] tem=new int[(end1-start1+1)+(end2-start2+1)];
        int j=0;
        int e1=start1;
        int e2=start2;
        while(e1<=end1 && e2<=end2){
            if(nums[e1]<=nums[e2]){
                tem[j++]=nums[e1++];
            }else{
                tem[j++]=nums[e2++];
            }
        }
        while(e1<=end1){
            tem[j++]=nums[e1++];
        }
        while(e2<=end2){
            tem[j++]=nums[e2++];
        }
        for(int i=0;i<tem.length;i++){
            nums[start1+i]=tem[i];
        }
    }



    public static void main0(String[] args) {
        int[] nums={49,49,49,49,49,49,1};
//        int[] nums={49,38,65,97,76,13,27,49};
        System.out.println(Arrays.toString(nums));
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    //快速排序的非递归写法与快慢指针法
    public static void quickSort(int[] nums){
        quickSortNon(nums,0,nums.length-1);
    }
    public static void quickSortNon(int[] nums,int start,int end){
        if(start>=end){
            return ;
        }
        Stack<Integer> s=new Stack<>();
        s.push(start);
        s.push(end);
        while(!s.isEmpty()){
            int right=s.pop();
            int left=s.pop();
            int tem=quick(nums,left,right);
            if(tem+1<=end && right-(tem+1)>=1 ){
                s.push(tem+1);
                s.push(right);
            }
            if(start<=tem-1 && tem-1-left>=1) {
                s.push(left);
                s.push(tem-1);
            }
        }
    }
    public static void quickSort(int[] nums,int start,int end){
        if(start>=end){
            return ;
        }
        //quick是一趟排序，逻辑上再递归返回的下标的左右区间完成排序
        int pit=quick(nums,start,end);
        quickSort(nums,start,pit-1);
        quickSort(nums,pit+1,end);
    }
    public static int quick(int[] nums,int start,int end){
        int post=start;
        int pre=start+1;
        int key=nums[start];
        while(pre<=end){
            if(nums[pre]<=key){
                swap(nums,pre,++post);
            }
            pre++;
        }
        swap(nums,start,post);
        return post;
    }
    public static void swap(int[]nums,int e1,int e2){
        int tem=nums[e1];
        nums[e1]=nums[e2];
        nums[e2]=tem;
    }
}
