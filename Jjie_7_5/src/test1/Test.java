package test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        String s = "barfoofoobarthefoobarman";String[] words = {"bar", "foo", "the"};
        String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";String[] words = {"fooo","barr","wing","ding","wing"};

        System.out.println(findSubstring(s, words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<>();
        HashMap<String, Integer> m = new HashMap<>();
        int len = words[0].length(), count = words.length, length = s.length();
        if (len * count > length) return ret;
        for (String tem : words) {
            if (m.get(tem) == null) m.put(tem, 1);
            else m.put(tem, m.get(tem) + 1);
        }

        for(int i=0,start=0;i<count;i++){
            start=len*i;
            String tem=s.substring(start,start+len);
            if(m.get(tem)!=null) {
                m.put(tem, m.get(tem) - 1);
            }
        }
        for(int i=count,start;i<length/len;i++){
            start=len*i;
            if(check(m)) ret.add(i*len-count*len);
            String out=s.substring((i-count)*len,(i-count)*len+len);
            if(m.get(out)!=null){
                m.put(out,m.get(out)+1);
            }
            String tem=s.substring(start,start+len);
            if(m.get(tem)!=null){
                m.put(tem,m.get(tem)-1);
            }
        }
        if(check(m)) ret.add(length-len*count);
        return ret;
    }
    public static boolean check(HashMap<String,Integer> m){
        for(String tem:m.keySet()){
            if(m.get(tem)!=0) return false;
        }
        return true;
    }
}
