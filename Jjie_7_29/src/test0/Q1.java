package test0;

import java.util.HashMap;

public class Q1 {
    public static void main(String[] args) {
        String s="pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        int ret=0;
        HashMap<Character,Integer> m=new HashMap<>();
        int left=0,right=0;
        int length=s.length();
        for(;right<length;right++){
            char c=s.charAt(right);
            m.put(c, m.getOrDefault(c,0)+1);
            while(m.get(c)>1){
                if(s.charAt(left)==c) m.put(c,1);
                else m.remove(s.charAt(left));
                left++;
            }
            ret=Math.max(ret,m.size());
        }
        return ret;
    }
}
