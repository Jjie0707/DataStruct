package test0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar","foo","the"};
        System.out.println(findSubstring(s, words));
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<>();
        int len = words[0].length(), count = words.length, length = s.length();
        if (len * count > length) return ret;
        for(int k=0;k<len;k++){
            //从不同的位置开始匹配 范围是[0,len)
            if(k+len*count>length) return ret;
            HashMap<String, Integer> m = new HashMap<>();
            for(String tem:words){
                if(m.get(tem)==null) m.put(tem,1);
                else m.put(tem,m.get(tem)+1);
            }
            for(int i=k;i<k+len*count;i+=len){
                String tem=s.substring(i,i+len);
                if(m.get(tem)!=null) m.put(tem,m.get(tem)-1);
            }
            for(int i=k+len*count;i+len<=length;i+=len){
                if(check(m)) ret.add(i-len*count);
                String out=s.substring(i-len*count,i-len*count+len);
                if(m.get(out)!=null) m.put(out,m.get(out)+1);
                String in=s.substring(i,i+len);
                if(m.get(in)!=null) m.put(in,m.get(in)-1);
            }
        }
        return ret;
    }
    public static boolean check(HashMap<String,Integer> m){
        for(String tem:m.keySet()){
            if(m.get(tem)!=0) return false;
        }
        return true;
    }
}
