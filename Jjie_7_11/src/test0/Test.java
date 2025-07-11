package test0;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int days = 1;
//        int[][] meetings = {{3, 4}, {4, 8}, {2, 5}, {3, 8}};
//        int[][] meetings = {{2,4}, {1, 3}};
        int[][] meetings={{1,1}};
        System.out.println(countDays(days, meetings));
    }
    public static int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(e1,e2)->e1[0]-e2[0]);
        int end=meetings[0][1],sum=meetings[0][1]-meetings[0][0]+1;
        for(int i=1;i< meetings.length;i++){
            int s=meetings[i][0],e=meetings[i][1];
            if(e<=end) continue;
            else{
                boolean flag=true;
                if(end>=s) {
                    s=end;flag=false;
                }
                sum+=(e-s);
                if(flag) sum++;
                end=e;
            }
        }
        return days-sum;
    }
}
