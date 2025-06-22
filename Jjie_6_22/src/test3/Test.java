package test3;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String word="uzzezzuzenzu";
        int k=0;
        System.out.println(minimumDeletions(word, k));
    }
    public static int func(int[] nums,int start,int end,int k){
        if(nums[end]-nums[start]<=k){
            return 0;
        }else{
            int count = 0;
            for (int i = start; i <=end; i++) {
                if (nums[i] == nums[end]) {
                    count++;
                }
            }
            return Math.min(nums[start] + func(nums, start + 1, end, k),count*( nums[end] - (nums[start] + k))+func(nums,start,end-count,k));
        }
    }
    public static int minimumDeletions(String word, int k) {
        int ret=0;
        int[] words=new int[26];
        int length=word.length();
        int count=0;
        for(int i=0;i<length;i++){
            if(words[word.charAt(i)-'a']==0) count++;
            words[word.charAt(i)-'a']++;
        }
        int j=0;
        int[] arr=new int[count];
        for(int i=0;i<26;i++){
            if(words[i]!=0){
                arr[j++]=words[i];
            }
        }
        Arrays.sort(arr);
        //把出现频率从小到大排序了
        return func(arr,0,count-1,k);
    }
}
