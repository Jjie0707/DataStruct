package test0;

import java.util.HashMap;
import java.util.HashSet;


public class Test {
    public static void main(String[] args) {
        int[] edges={2,0,0};
        int node1=2;
        int node2=0;
        HashSet<Integer> s=new HashSet<>();
        System.out.println(closestMeetingNode(edges, node1, node2));
    }
    public static int closestMeetingNode(int[] edges, int node1, int node2) {
        int length=edges.length;
        boolean[] visited = new boolean[length];
        int next=node1;
        int path=0;
        HashMap<Integer,Integer> m=new HashMap<>();
        while(next!=-1 && visited[next]==false){
            visited[next]=true;
            m.put(next,path);
            path++;
            next=edges[next];
        }
        //走到这里已经完成了一次不重复的遍历
        next=node2;
        visited=new boolean[length];
        int ret=-1;
        int min=Integer.MAX_VALUE;
        path=0;
        while(next!=-1 && visited[next]==false){
            if(m.get(next)!=null){
                int tem=m.get(next);
                int max=Math.max(tem,path);
                if(max<min || (max==min && next<ret) ){
                    min=max;
                    ret=next;
                }
            }
            path++;
            visited[next]=true;
            next=edges[next];
        }
        return ret;
    }
}
