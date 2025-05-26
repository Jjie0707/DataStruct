package test0;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Test {
    //判断是否回文的函数
    public static boolean func(String s){
        int left=0;
        int right=s.length()-1;
        while(left<right){
            if( s.charAt(left++) != s.charAt(right--) ){
                return false;
            }
        }
        return true;
    }

    public static int longestPalindrome(String[] words) {
        int ret=0;
        int length=words.length;
        HashMap<String,Integer> m=new HashMap<>();
        for(int i=0;i<length;i++){

            if(m.get(words[i])==null){
                StringBuilder sb=new StringBuilder(words[i]);
                sb.reverse();
                words[i]=sb.toString();
                if(m.get(words[i])==null){
                    m.put(words[i],1);
                }else{
                    m.put(words[i] ,m.get(words[i]) + 1);
                }
            }else{
                ret+=2*words[i].length();
                int tem=m.get(words[i]);
                if(tem==1){
                    m.remove(words[i]);
                }else{
                    m.put(words[i],tem-1 );
                }
            }
        }
        int max=0;
        for(String key:m.keySet()){
            if(func(key)){
                if(key.length()>max){
                    max=key.length();
                }
            }
        }
        return ret+max;
//        int ret = 0;
//        int length = words.length;
//        HashMap<String, Integer> s = new HashMap<>();
//        for (int i = 0; i < length; i++) {
//            StringBuilder tem = new StringBuilder(words[i]);
//            tem.reverse();
//            if (s.get(words[i]) == null) {
//                words[i] = tem.toString();
//                s.put(words[i], 1);
//            } else {
//                int count=s.get(words[i]);
//                s.remove(words[i]);
//                ret += 2 * words[i].length();
//            }
//        }
//        int max=0;
//        Set<String> list=s.keySet();
//        for(String key:list){
//            if(func(key)){
//                if(key.length()>max) {
//                    max = key.length();
//                }
//            }
//        }
//        return ret+max;
    }

    public static void main(String[] args) {
        String[] words = {"qo","fo","fq","qf","fo","ff","qq","qf","of","of","oo","of","of","qf","qf","of"};
        System.out.println(longestPalindrome(words));
    }
}
