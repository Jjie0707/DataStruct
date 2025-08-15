package test0;

public class Test {
    public static void main(String[] args) {
        int[] arr={4,-7,2};
        int lower=3;
        int upper=6;
        System.out.println(numberOfArrays(arr,lower,upper));
    }


    public static int numberOfArrays(int[] nums, int lower, int upper) {
        int length=nums.length;
        int j=0;
        int min=nums[0];
        // for(int i=0;i<length;i++){
        //     if(nums[i]<=nums[0]){
        //         j=i;
        //         min=nums[i];
        //     }
        // }
        // //走到这里说明已经找到了数组的最小值
        // //最小值的下标是j
        for(int i=0;i<length;i++){
            if(nums[i]<=nums[0]){
                j=i;
                min=nums[i];
            }
        }
        //走到这里说明已经找到了数组的最小值
        //最小值的下标是j
        int count=0;
        min=lower;
        for(;min<=upper;min++){
            int left=j-1;
            int right=j+1;
            //确保走到这里的下标一定合法
            int temR=min;
            int temL=min-nums[j];
            if(!(temR<=upper && temR>=lower) || !(temL<=upper && temL>=lower)){
                continue;
            }
            boolean flag=true;
            while(left>=0){
                temL=temL-nums[left];
                if(!(temL<=upper && temL>=lower)){
                    count--;
                    flag=false;
                    break;
                }
                left--;
            }
            while(flag && right<length){
                temR=temR+nums[right];
                if(!(temR<=upper && temR>=lower) ){
                    count--;
                    break;
                }
                right++;
            }
            count++;
        }
        return count;
    }
}
