package test0;

import java.util.HashMap;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        String s= "bac";
        System.out.println(robotWithString(s));
    }
    public static String robotWithString(String s) {
        StringBuilder ans=new StringBuilder();
        char min='z';
        int length=s.length();
        HashMap<Character,Integer> m=new HashMap<>();
        for(int i=0;i<length;i++){
            char c=s.charAt(i);
            if(m.get(c)==null){
                m.put(c,1);
            }else{
                m.put(c,m.get(c)+1);
            }
            if(c<min){
                min=c;
            }
        }
        int count=m.get(min);
        //走到这里统计了最小的字符
        Stack<Character> st=new Stack<>();
        for(int i=0;i<length;i++){
            //最小的字符没有打印完
            char tem=s.charAt(i);
            if(count>0){
                if(tem==min){
                    ans.append(tem);
                    count--;
                }else{
                    //只要不是字符串之中最小的字符都加入栈之中(最小字符没有用完的情况)
                    st.push(tem);
                }
            }else{
                if(st.isEmpty()){
                    st.push(tem);
                }else if(tem<=st.peek()){
                    st.push(tem);
                }else if(tem>st.peek()){
                    while(!st.isEmpty() && tem>st.peek()){
                        ans.append(st.pop());
                    }
                    st.push(tem);;
                }
            }
        }
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        return ans.toString();
    }
}
