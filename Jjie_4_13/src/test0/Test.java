package test0;

public class Test {
    public static void main(String[] args) {
//        int[] arr={0,1,2,2,3,0,4,2};
        int[] arr={3,2,2,3};
        int length=removeElement(arr,2);
        for(int i=0;i<length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static int removeElement(int[] nums, int val){
        int length=nums.length;
        int count=0;
        if (length==0){
            return 0;
        }
        for(int i=0;i<=length-count;i++){
            if(nums[i]==val){
                count++;
                while(length-count>=0 && length-count>i){
                    if(nums[length-count]!=val){
                        break;
                    }else{
                        count++;
                    }
                }
                if(length-count<=i) break;
                nums[i]=nums[length-count];
            }
        }
        return length-count;
    }


    public static void main0(String[] args) {
        int[] arr={1,1,2,3};
        int length=removeDuplicates(arr);
        for(int i=0;i<length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static int removeDuplicates(int[] nums) {
        int length=nums.length;
        int pre=0;
        int next=0;
        int count=0;
        for(int i=0;i<length;i++){
            if(i==0){
                count++;
                pre++;
                next++;
            }else{
                if(nums[i]>nums[i-1]){
                    nums[pre]=nums[i];
                    count++;
                    pre++;
                    next++;
                }else{
                    next=i;
                    while(next<length && !(nums[next]>nums[next-1])){
                        next++;
                    }//现在找到了下一个不重复的数
                    if(pre>=length || next>=length){
                        break;
                    }
                    nums[pre]=nums[next];
                    i=next;
                    pre++;
                    count++;
                }
            }
        }
        return count;
    }




    public void merge(int[] nums1, int m, int[] nums2, int n){
        // for(int i=0;i<n;i++){
        //     nums1[m+i]=nums2[i];
        // }
        // Arrays.sort(nums1);
        int index=m+n-1;
        int s2=n-1;
        int s1=m-1;
        while(true){
            if(s1>=0 && s2>=0 && index>=0 && nums1[s1]>nums2[s2]){
                nums1[index]=nums1[s1];
                index--;
                s1--;
            }else if(s1>=0 && s2>=0 && index>=0 && nums1[s1]<nums2[s2]){
                nums1[index]=nums2[s2];
                index--;
                s2--;
            }else{
                break;
            }
        }
        //走到这里一定是 s1或者 s2小于0了 只需要将没排完的数组拷贝上去就可以了
        for(;s2>=0;s2--){
            nums1[index]=nums2[s2];
            index--;
        }
        for(;s1>=0;s1--){
            nums1[index]=nums1[s1];
            index--;
        }
    }
}
