package test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
       String  s1 = "parker", s2 = "morris", baseStr = "parser";
        System.out.println(smallestEquivalentString(s1, s2, baseStr));
    }
    public static void main0(String[] args) {
        PriorityQueue<Integer> tem=new PriorityQueue<>();
        tem.offer(3);
        tem.offer(2);
        tem.offer(3);
        System.out.println(tem.peek());
        System.out.println(tem.size());
    }
    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        int length=s1.length();
        PriorityQueue<Character>[] tem=new PriorityQueue[26];
        for(int i=0;i<length;i++){
            char c1=s1.charAt(i);
            char c2=s2.charAt(i);
            if(tem[c1-97]!=null || tem[c2-97]!=null){
                PriorityQueue<Character> heap;
                if(tem[c1-97]!=null ){
                    heap=tem[c1-97];
                }else {
                    heap=tem[c2 - 97];
                }
                heap.offer(c1);
                heap.offer(c2);
                tem[c1-97]=heap;
                tem[c2-97]=heap;
            }else{
                PriorityQueue<Character> heap=new PriorityQueue<>();
                heap.offer(c1);
                heap.offer(c2);
                tem[c1-97]=heap;
                tem[c2-97]=heap;
            }
        }
        length=baseStr.length();
        StringBuilder sb=new StringBuilder();

        for (int i = 0; i < length; i++) {
            if (tem[baseStr.charAt(i) - 97] != null) {
                sb.append(tem[baseStr.charAt(i) - 97].peek());
            } else {
                sb.append(baseStr.charAt(i));
            }
        }
        return sb.toString();
    }
}
