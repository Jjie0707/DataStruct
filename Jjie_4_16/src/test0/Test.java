package test0;

public class Test {
    class Solution {
        public static boolean check(int[] arr,int start,int end,int k){
            int count=0;
            for(int i=start;i<=end;i++){
                for(int j=i;j<=end;j++){
                    if(arr[i]==arr[j]){
                        count++;
                    }
                    if(count>=k){
                        return true;
                    }
                }
            }
            return count==k;
        }
        public long countGood(int[] nums, int k) {
            long count=0;

            int length=(int)((2*k+1)/2);
            int left=0;
            int right=left+length;

            int end=nums.length-1;
            while(true){
                while(!check(nums,left,right))
            }
        }
    }
}
