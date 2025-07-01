package test1;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] nums={7,10,7,3,7,5,4};
        int target = 12;
        System.out.println(numSubseq(nums, target));
    }
    public static int func(int[] nums,int x,int left){
        int right=nums.length;
        while(left<right){
            int mid=(left+right)/2;
            if(nums[mid]>x){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    public static int numSubseq(int[] nums, int target) {
        long MOD=(long)(1e9+7);
        int[] fac=new int[nums.length+1];
        fac[0]=1;
        for(int i=1;i<=nums.length;i++){
            fac[i]=(int)((fac[i-1]*2)%MOD);
        }
        Arrays.sort(nums);
        long ret=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]*2>target){
                break;
            }
            int j=func(nums,target-nums[i],i+1)-1;
            ret=(ret+fac[j-i])%MOD;
        }
        return (int)(ret%MOD);
    }
}
