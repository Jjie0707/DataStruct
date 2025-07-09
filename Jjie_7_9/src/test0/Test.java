package test0;

import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        int eventTime = 96, k = 3;
        int[] startTime = {4,11,16,53}, endTime = {11,16,27,77};
        System.out.println(maxFreeTime(eventTime, k, startTime, endTime));
    }
    public static int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int length=startTime.length;
        int[] gap=new int[length+1];
        int end=0;
        for(int i=0;i<length;i++){
            int s=startTime[i],e=endTime[i];
            gap[i]=s-end;
            end=e;
        }
        gap[length]=eventTime-end;

        //gap统计了所有会议之间的间隔
        k--;
        int ret=0;
        int left=0;
        int count=0,sum=0;
        for(int right=0;right<gap.length;right++){
            if(gap[right]==0) count++;
            sum+=gap[right];
            while(count>k){
                if(gap[left]==0) count--;
                sum-=gap[left];
                left++;
            }
            while(right-left>k+1){
                if(gap[left]==0) count--;
                sum-=gap[left++];
            }
            //走到这里一定确保零的
            ret=Math.max(ret,sum);
        }
        return ret;
    }
}
