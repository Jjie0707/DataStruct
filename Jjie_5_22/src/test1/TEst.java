package test1;

public class TEst {
    public static void main(String[] args) {
        int[] nums={2,2,1};
        sortColors(nums);
    }
    public static void sortColors(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            while(left<right && nums[right]==2){
                right--;
            }//走到这里可以确定nums[right]一定不等于2
            if(nums[left]==2){
                swap(nums,left,right);
                right--;
            }
            left++;
        }
        left=0;
        while(left<right){
            while(left<right && nums[right]==1){
                right--;
            }
            if(nums[left]==1){
                swap(nums,left,right--);
            }
            left++;
        }
    }
    public static void swap(int[] nums,int e1,int e2){
        int tem=nums[e1];
        nums[e1]=nums[e2];
        nums[e2]=tem;
    }
}
