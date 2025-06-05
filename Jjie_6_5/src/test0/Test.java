package test0;

public class Test {
    public static void quickSort(int[] nums){
        quick(nums,0,nums.length-1);
    }
    public static void quick(int[] nums,int start,int end){
        if(start>=end){
            return;
        }
        int par=sort(nums,start,end);
        quick(nums,start,par-1);
        quick(nums,par+1,end);
    }
    public static int sort(int[] nums,int start,int end){
        
    }
}
