package test3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        String s1 = "cgokcgerolkgksgbhgmaaealacnsshofjinidiigbjerdnkolc",
                s2 = "rjjlkbmnprkslilqmbnlasardrossiogrcboomrbcmgmglsrsj",
                baseStr = "bxbwjlbdazfejdsaacsjgrlxqhiddwaeguxhqoupicyzfeupcn";
        System.out.println(smallestEquivalentString(s1, s2, baseStr));
    }
    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        ArrayList<ArrayList<Character>> words=new ArrayList<>();
        ArrayList<PriorityQueue<Character>> heap=new ArrayList<>();
        int length=s1.length();
        for(int i=0;i<length;i++){
            char c1=s1.charAt(i);
            char c2=s2.charAt(i);
            int size=words.size();
            boolean flag=true;
            for(int j=0;j<size;j++){
                if(words.get(j).contains(c1) || words.get(j).contains(c2)){
                    words.get(j).add(c1);
                    words.get(j).add(c2);
                    heap.get(j).offer(c1);
                    heap.get(j).offer(c2);
                    flag=false;
                    break;
                }
            }
            if(flag){
                ArrayList<Character> list=new ArrayList<>();
                list.add(c1);
                list.add(c2);
                PriorityQueue<Character> tem=new PriorityQueue<>();
                tem.offer(c1);
                tem.offer(c2);
                words.add(list);
                heap.add(tem);
            }
        }
        length=baseStr.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<length;i++){
            boolean flag=true;
            char c=baseStr.charAt(i);
            for(int j=0;j< words.size();j++){
                if (words.get(j).contains(c)) {
                    sb.append(heap.get(j).peek());
                    flag=false;
                    break;
                }
            }
            if(flag){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
