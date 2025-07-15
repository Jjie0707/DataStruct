package test0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String[] strs={"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret=new ArrayList<>();
        List<List<Character>> list=new ArrayList<>();
        for(String tem:strs){
            ArrayList<Character> l=new ArrayList<>();
            int length=tem.length();
            for(int i=0;i<length;i++) l.add(tem.charAt(i));

            int index=contains(list,l);
            if (list.isEmpty() || index==-1) {
                List<String> in = new ArrayList<>();
                in.add(tem);
                ret.add(in);
                list.add(l);
            } else {
                ret.get(index).add(tem);
            }
        }
        return ret;
    }
    private static int contains(List<List<Character>> list,ArrayList<Character> tem){
        for(int i=0;i<list.size();i++) {
            List<Character> l=list.get(i);
            if(l.isEmpty() && tem.isEmpty()) return i;
            l.sort((e1,e2)->(int)(e1-e2));
            tem.sort((e1,e2)->(int)(e1-e2));
            if(l.equals(tem)) return i;
        }
        return -1;
    }
}
