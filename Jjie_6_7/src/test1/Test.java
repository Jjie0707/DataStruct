package test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        String s="d*o*";
        System.out.println(clearStars(s));
    }
    public static String clearStars(String s) {
        StringBuilder ans=new StringBuilder();
        int length=s.length();
        PriorityQueue<Character> heap=new PriorityQueue<>();
        HashSet<Integer> set=new HashSet<>();
        HashMap<Character, ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<length;i++){
            char c=s.charAt(i);
            if(c=='*'){
                char tem=heap.peek();
                ArrayList<Integer> list=map.get(tem);
                set.add(list.getLast());
                list.removeLast();
                heap.poll();
            }else{
                heap.offer(c);
                if(map.get(c)==null){
                    ArrayList<Integer> tem=new ArrayList<>();
                    tem.add(i);
                    map.put(c,tem);
                }else{
                    ArrayList<Integer> tem=map.get(c);
                    tem.add(i);
                }
            }
        }
        for(int i=0;i<length;i++){
            char c=s.charAt(i);
            if(c!='*' && !set.contains(i)){
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
