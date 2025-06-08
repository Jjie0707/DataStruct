package test0;

import java.util.HashSet;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
//        String s="aaba**";
        String s="abc";
        System.out.println(clearStars(s));
    }

    public static String clearStars(String s) {
        StringBuilder ans=new StringBuilder();
        PriorityQueue<Character> heap=new PriorityQueue<>();
        int length=s.length();
        int count=0;
        for(int i=0;i<length;i++){
            char c=s.charAt(i);
            if(c=='*'){
                count++;
            }else{
                heap.offer(c);
            }
        }
        if(count==0){
            return s;
        }
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<length;i++){
            char c=s.charAt(i);
            if(c=='*'){
                for(int j=i-1;j>=0;j--){
                    if(s.charAt(j)==heap.peek() && !set.contains(j)){
                        heap.poll();
                        set.add(j);
                        break;
                    }
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
