package test0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String s = "abab", p = "ab";
        System.out.println(findAnagrams(s, p));
    }
    public static List<Integer> findAnagrams(String s, String p) {
        int len=p.length(),length=s.length();
        List<Integer> ret=new ArrayList<>();
        HashMap<Character,Integer> hash1=new HashMap<>();
        HashMap<Character,Integer> hash2=new HashMap<>();
        for(int i=0;i<len;i++){
            if(hash1.get(s.charAt(i))==null){
                hash1.put(s.charAt(i),1);
            }else{
                hash1.put(s.charAt(i),hash1.get(s.charAt(i))+1);
            }
            if(hash2.get(p.charAt(i))==null){
                hash2.put(p.charAt(i),1);
            }else{
                hash2.put(p.charAt(i),hash1.get(p.charAt(i))+1);
            }
        }
        for(int i=len;i<length;i++){
            if(check(hash1,hash2)) ret.add(i-len);
            if(hash1.get(s.charAt(i-len))==1) hash1.remove(s.charAt(i-len));
            else hash1.put(s.charAt(i-len),hash1.get(s.charAt(i-len))-1);

            if(!hash1.containsKey(s.charAt(i))) hash1.put(s.charAt(i),1);
            else hash1.put(s.charAt(i),hash1.get(s.charAt(i))+1);
        }
        if(check(hash1,hash2)) ret.add(length-len);
        return ret;
    }
    public static boolean check(HashMap<Character,Integer> hash1,
                                HashMap<Character,Integer> hash2){
        for(char c:hash2.keySet()){
            if(hash1.get(c)==null || !hash1.get(c).equals(hash2.get(c))){
                return false;
            }
        }
        return true;
    }
}
