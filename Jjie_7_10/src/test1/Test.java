package test1;

import java.util.PriorityQueue;

public class Test {
    public static int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int length=startTime.length;
        int[] gap=new int[length+1];
        int end=0;
        int[][] max=new int[3][2];

        for(int i=0;i<length;i++){
            int s=startTime[i],e=endTime[i];
            gap[i]=s-end;
            end=e;
        }
        gap[length]=eventTime-end;

        for(int i=0;i<gap.length;i++){
            if(gap[i]>max[0][1]){
                max[2][0]=max[1][0];
                max[2][1]=max[1][1];
                max[1][0]=max[0][0];
                max[1][1]=max[0][1];
                max[0][0]=i;
                max[0][1]=gap[i];
            }else if(gap[i]>max[1][1]){
                max[2][0]=max[1][0];
                max[2][1]=max[1][1];
                max[1][0]=i;
                max[1][1]=gap[i];
            }else if(gap[i]>max[2][1]){
                max[2][0]=i;
                max[2][1]=gap[i];
            }
        }//  a >= b >= c
        int ret=0;
        for(int i=0;i<length;i++){
            int tem=endTime[i]-startTime[i];
            int g1=gap[i],g2=gap[i+1];
            if(check(max,i,tem)){
                ret=Math.max(ret,g1+g2+tem);
            }else{
                ret=Math.max(ret,g1+g2);
            }
        }
        return ret;
    }
    public static boolean check(int[][] max,int index,int tem){
        for(int i=0;i<3;i++){
            if(max[i][0]!=index && max[i][0]!=index+1 && max[i][1]>=tem) return true;
        }
        return false;
    }
}
