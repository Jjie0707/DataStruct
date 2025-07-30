package test0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q2 {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams(s, p));
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret=new ArrayList<>();
        HashMap<Character,Integer> m=new HashMap<>();
        int len=p.length(),length=s.length();
        if(length<len) return ret;

        for(int i=0;i<len;i++){
            char c=p.charAt(i);
            m.put(c,m.getOrDefault(c,0)+1);
        }
        for(int i=0;i<len;i++){
            char c=s.charAt(i);
            if(m.get(c)!=null) m.put(c,m.get(c)-1);
        }
        int left=0;
        for(int i=len;i<length;i++){
            if(check(m)) ret.add(left);

            char c=s.charAt(i);
            char c2=s.charAt(left++);
            if(m.get(c2)!=null) m.put(c2,m.get(c2)+1);
            if(m.get(c)!=null) m.put(c,m.get(c)-1);
        }
        if(check(m)) ret.add(left);
        return ret;
    }
    public static boolean check(HashMap<Character,Integer> m){
        for(char c:m.keySet()){
            if(m.get(c)!=0) return false;
        }
        return true;
    }
}
