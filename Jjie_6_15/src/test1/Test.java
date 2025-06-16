package test1;

import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        String s="pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static  int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();
        int ret=Integer.MIN_VALUE;
        int length=s.length();
        for(int left=0,right=0;right<length;right++){
            char c=s.charAt(right);

            while(set.contains(c)){
                ret=Math.max(ret,set.size());
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
        }
        return ret==Integer.MIN_VALUE ? 0 : ret;
    }
}
