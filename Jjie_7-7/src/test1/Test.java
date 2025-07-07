package test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;


public class Test {
    public static int maxEvents(int[][] events) {
        int ret=0;
        if(events.length==0) return 0;
        int min=events[0][0],max=events[0][1];
        for(int[] tem:events){
            int m=tem[0],mx=tem[1];
            min=Math.min(min,m);
            max=Math.max(max,mx);
        }
        ArrayList<int[]>[] list=new ArrayList[max+1];
        Arrays.setAll(list,i->new ArrayList<>());
        for(int[] tem:events){
            list[tem[0]].add(tem);
        }
        //已经按照开始时间分好组了
        PriorityQueue<int[]> heap=new PriorityQueue<>();
        for(int i=1;i<=max;i++){
            while(!heap.isEmpty() && heap.peek()[1]<i) heap.poll();
            for(int[] tem:list[i]) heap.offer(tem);
            if(!heap.isEmpty()){
                ret++;
                heap.poll();
            }
        }
        return ret;
    }
}
