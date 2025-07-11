package test0;

public class Test {
    public static void main(String[] args) {
        int eventTime=10;
        int[] startTime={0,3,7,9},endTime={1,4,8,10};
        System.out.println(maxFreeTime(eventTime, startTime, endTime));
    }
    public static int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int length=startTime.length;
        int[] gap=new int[length*2+1];
        int end=0;
        for(int i=0;i<length;i++){
            int s=startTime[i],e=endTime[i];
            gap[i*2]=s-end;
            if(i*2+1<length*2+1) gap[i*2+1]=e-s;
            end=e;
        }
        gap[length*2]=eventTime-end;
        int ret=0;
        for(int left=0;left+2<gap.length;left+=2){
            int right=left+2;
            int g1=gap[left],g2=gap[right];
            int count= (g1 == 0 ? 1 : 0) + (g2 == 0 ? 1 : 0);
            if(count==0) ret=Math.max(ret,g1+g2+(check(gap,gap[left+1],left,right)?gap[left+1]:0));
            else if(count==1){
                int index=g1==0?g2:g1;
                ret=Math.max(ret,g1+g2+(check(gap,gap[left+1],index,index)?gap[left+1]:0));
            }else{//count==2
                ret=Math.max(ret,(check(gap,gap[left+1],left+1,left+1)?gap[left+1]:0));
            }
        }
        return ret;
    }
    public static boolean check(int[] gap,int tem,int left,int right){
        for(int i=0;i<gap.length;i+=2){
            if(i!=left && i!=right)
                if(gap[i]>=tem) return true;
        }
        return false;
    }
}
