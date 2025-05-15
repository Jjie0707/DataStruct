package test0;

import java.util.Arrays;

public class Test {
    public static void quickSort(int[] nums){
        quickSort(nums,0,nums.length);
    }
    public static void quickSort(int[] nums,int start,int end){

    }



    public static void mergeSort(int[] nums){
        mergeSort(nums,0,nums.length-1);
    }
    public static void mergeSort(int[] nums,int left,int right){
        if(left>=right){
            return ;
        }
        int mid=(left+right)/2;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        int i=left;
        int j=mid+1;
        int[] tem=new int[right-left+1];
        int k=0;
        while(i<=mid && j<=right){
            if(nums[i]<nums[j]){
                tem[k]=nums[i];
                k++;
                i++;
            }else{
                tem[k]=nums[j];
                k++;
                j++;
            }
        }
        while(i<=mid){
            tem[k]=nums[i];
            k++;
            i++;
        }
        while(j<=right){
            tem[k]=nums[j];
            k++;
            j++;
        }
        for(int n=0;n<k;n++){
            nums[left+n]=tem[n];
        }
    }
    public static void heapSort(int[] nums){
        int length=nums.length;
        int end=length-1;
        buildHeap(nums);
        //走到这里构建成了大堆
        while(end>=0){
            swap(nums,end,0);
            end--;
            adjustDown(nums,0,end);
        }
    }
    public static void buildHeap(int[] nums){
        int length=nums.length;
        for(int i=(length-2)/2;i>=0;i--){
            adjustDown(nums,i,length-1);
        }
    }
    public static void adjustDown(int[] nums,int start,int end){
        int parent=start;
        while(parent<=end){
            int child=parent*2+1;
            if(child+1<=end && nums[child]<=nums[child+1]){
                child++;
            }
            if(child>end){
                break;
            }
            if(nums[parent]<nums[child]){
                swap(nums,parent,child);
            }
            parent=child;
        }
    }

    public static void selectSort(int[] nums){
        int length=nums.length;
        for(int i=0;i<length;i++){
            int minindex=i;
            int j=i;
            while(j<length){
                if(nums[j]<=nums[minindex]){
                    minindex=j;
                }
                j++;
            }
            swap(nums,minindex,i);
        }
    }

    public static void swap(int[] nums,int e1,int e2){
        int tem=nums[e1];
        nums[e1]=nums[e2];
        nums[e2]=tem;
    }

    public static void main0(String[] args) {
        int[] nums={2,4,3,1,78,3465,86,31};
        System.out.println(Arrays.toString(nums));
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void main1(String[] args) {
        int[] nums={2,2,2,2,2,2,2};
        System.out.println(Arrays.toString(nums));
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
