package test1;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        String s="mmuqezwmomeplrtskz";
        System.out.println(robotWithString(s));
    }
    public static boolean func(int[] words,int c){
        for(int i=0;i<c-97;i++){
            if(words[i]!=0){
                return false;
            }
        }    //fnohopzv
        //确保比字符c小的字符都已经出去了
        return true;
    }
    public static String robotWithString(String s) {
        StringBuilder ans=new StringBuilder();
        int length=s.length();
        int[] words=new int[26];
        for(int i=0;i<length;i++){
            char c=s.charAt(i);
            words[c-97]+=1;
        }
        //走到这里统计了每个字母出现的次数
        Stack<Character> st=new Stack<>();
        for(int i=0;i<length;i++){
            char c=s.charAt(i);
            if(st.isEmpty() || c<st.peek()){
                st.push(c);
                words[c-97]--;
            }else{
                //st.peek()<c
                while( ( i==length-1 && ( !st.isEmpty() && st.peek()<=c) ) || (!st.isEmpty() && (st.peek()<=c && func(words,st.peek())) ) ){
                    char tem=st.pop();
                    ans.append(tem);
                }
                st.push(c);
                words[c-97]--;
            }
        }
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        return ans.toString();
    }
}
//eekstrlpmomwzqummz
//eekstrlpmomwzqummz