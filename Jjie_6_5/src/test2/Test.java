package test2;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        String s1 = "parker", s2 = "morris", baseStr = "parser";
        System.out.println(smallestEquivalentString(s1, s2, baseStr));
    }

    public static  String smallestEquivalentString(String s1, String s2, String baseStr) {
        int length=s1.length();
        HashMap<ArrayList<Character> , PriorityQueue<Character>> s=new HashMap<>();
        for(int i=0;i<length;i++){
            char c1=s1.charAt(i);
            char c2=s2.charAt(i);
            boolean flag=true;
            for(ArrayList<Character> list:s.keySet()){
                if(list.contains(c1) || list.contains(c2)){

                    s.get(list).offer(c1);
                    s.get(list).offer(c2);
                    flag=false;
                    break;
                }
            }
            if(flag){
                ArrayList<Character> list=new ArrayList<>();
                list.add(c1);
                list.add(c2);
                PriorityQueue<Character> heap=new PriorityQueue<>();
                heap.offer(c1);
                heap.offer(c2);
                s.put(list,heap);
            }
        }
        length=baseStr.length();
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<length;i++){
            char c=baseStr.charAt(i);
            boolean flag=true;
            for(List list:s.keySet()){
                if(list.contains(c)){
                    ans.append(s.get(list).peek());
                    flag=false;
                    break;
                }
            }
            if(flag){
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
