package test0;

import java.util.HashMap;
import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        int[][] events={{1,2},{2,3},{3,4}};
        System.out.println(maxEvents(events));
    }
    public static int maxEvents(int[][] events) {
        int length=events.length;
//        HashSet<Integer> s=new HashSet<>();
        if(length==0) return 0;
        int min=events[0][0],max=events[0][1];
        for(int i=0;i<length;i++){
            int tem1=events[i][0];
            int tem2=events[i][1];
            min=Math.min(min,tem1);
            max=Math.max(max,tem2);
        }

        return Math.min(length,max-min+1);
    }
}
