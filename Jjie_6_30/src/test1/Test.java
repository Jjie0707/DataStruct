package test1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Test {
    public static void main(String[] args) {
        String s = "letsleetcode";
        int k = 2;
        System.out.println(longestSubsequenceRepeatedK(s, k));
    }
    private static char[] chars;

    public static String longestSubsequenceRepeatedK(String s, int k) {
        chars=new char[26];
        int length=s.length();
        for(int i=0;i<length;i++){
            chars[s.charAt(i)-'a']++;
        }
        ArrayList<Character> list=new ArrayList<>();
        for(char c=0;c<26;c++){
            if(chars[c]>=k){
                list.add((char)(c+'a'));
            }
        }
        //走到这里 list统计好了出现次数超过k的字符
        Deque<String> tem=new ArrayDeque<>();
        tem.add("");
        String ans="";
        while(!tem.isEmpty()){
            String cur=tem.poll();
            String nex;
            for(char c:list){
                nex=cur+c;
                if(check(s,nex,k)){
                    if(nex.length()>ans.length()
                    || (nex.length()==ans.length() && nex.compareTo(ans)>0)){
                        ans=nex;
                    }
                    tem.add(nex);
                }
            }
        }
        return ans;
    }
    public static boolean check(String s,String t,int k){
        int i=0,len=t.length(),length=s.length();
        for(int j=0;j<length;j++){
            char c=s.charAt(j);
            if(c==t.charAt(i)) i++;
            if(i==len) {
                k--;
                i=0;
            }
            if(k<=0) return true;
        }
        return false;
    }
}
