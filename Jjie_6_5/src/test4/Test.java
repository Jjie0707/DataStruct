package test4;

public class Test {
    public static void main(String[] args) {
        int n=19;
        System.out.println(isHappy(n));
    }
    public static  boolean isHappy(int n) {
        int fast=n;
        fast=option(fast,2);
        int slow=n;
        slow=option(slow,1);
        while(fast!=slow){
            fast=option(fast,2);
            slow=option(slow,1);
        }
        return fast==1;
    }
    public static int option(int num,int count){
        int tem=num;
        int ret=0;
        for(int i=0;i<count;i++){
            while(tem>0){
                ret+=Math.pow(tem%10,2);
                tem/=10;
            }
            tem=ret;
            ret=0;
        }
        return tem;
    }
}
