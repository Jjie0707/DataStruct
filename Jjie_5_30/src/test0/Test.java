package test0;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        HashSet<Character> hs = new HashSet<>();

        //write your code here......
        int length=str.length();
        for(int i=0;i<length;i++){
            char c=str.charAt(i);
            if(!hs.contains(c)){
                hs.add(c);
            }
        }
        for (char c:hs) {
            System.out.print(c);
        }
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
                if(max<=min){
                    min=max;
                    ret=next;
                }
                path++;
                visited[next]=true;
                next=edges[next];
            }
        }
        return ret;
    }
}
