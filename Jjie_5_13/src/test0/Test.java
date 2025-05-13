package test0;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String s="azbk";
        int[] arr= {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};
        ArrayList<Integer> list=new ArrayList<>();
        for (int j : arr) {
            list.add(j);
        }
        System.out.println(lengthAfterTransformations(s,1,list));
    }
    public static int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int MOD=1000000007;
        int[] chars=new int[26];
        int length=s.length();
        for(int i=0;i<length;i++){
            chars[s.charAt(i)-'a']++;
        }
        //走到这里统计出了每个字符出现的次数
        for(int i=0;i<t;i++){
            int[] tem=new int[26];
            for(int j=0;j<26;j++){
                for(int k=1;k<=nums.get(j);k++){
                    if(j+k<=25){
                        tem[j+k]=( tem[j+k]%MOD + chars[j]%MOD )%MOD;
                    }else{
                        tem[(j+k)%26]=( tem[(j+k)%26]%MOD + chars[j]%MOD )%MOD;
                    }
                }
            }
            chars=tem;
        }
        int ret=0;
        for(int i=0;i<length;i++){
            ret=(ret%MOD+chars[i]%MOD)%MOD;
        }
        return ret;
    }
}
