package test;

import java.util.Arrays;

public class Test {
    private int[][] events;
    private int count;
    private int[][] f;


    public  int maxValue(int[][] events, int k) {
        Arrays.sort(events,(e1,e2)->e2[0]-e1[0]);
        //按照起始时间排序
        this.events=events;
        this.count=events.length;
        this.f=new int[count][k+1];
        return dfs(0,k);
    }
    public int dfs(int i,int k){
        if(i>=count || k<=0) return 0;
        if(f[i][k]!=0) return f[i][k];
        int j=search(events,events[i][1],i+1);
        f[i][k]=Math.max(dfs(i+1,k),events[i][2]+dfs(j,k-1));
        return f[j][k];
    }
    public int search(int[][] events,int x,int i){
        int l=i,r=count;
        while(l<r){
            int mid=(l+r)>>1;
            if(events[mid][0]>x) r=mid;
            else l=mid+1;
        }
        return l;
    }
}
