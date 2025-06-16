package test1;

public class Test {
    public static void main(String[] args) {
        int num=123456;
        System.out.println(maxDiff(num));
    }
    public static int[] func(int n){
        int count=0;
        int tem=n;
        while(tem>0){
            count++;
            tem/=10;
        }
        //321
        int[] ret=new int[count];
        while(n>0){
            ret[count-1]=n%10;
            n/=10;
            count--;
        }
        return ret;
    }
    public static int maxDiff(int num) {
        int[] arr=func(num);
        int length=arr.length;
        int max=0;
        int maxindex=length-1;
        int min=-1;
        int minindex=length-1;
        for(int i=0;i<length;i++){
            if(arr[i]!=9 && i<=maxindex){
                maxindex=i;
                max=arr[i];
            }

            if(arr[i] !=1 && i<=minindex){
                min=arr[i];
                minindex=i;
            }
        }
        int ret1=0;
        int ret2=0;
        for(int i=0;i<length;i++){
            if(arr[i]==max){
                ret1=ret1*10+9;
            }else{
                ret1=ret1*10+arr[i];
            }

            if(arr[i]==min && arr[i]==arr[0]){
                ret2=ret2*10+1;
            }else if(arr[i]==min && arr[i]!=arr[0]){
                ret2=ret2*10;
            }else{
                ret2=ret2*10+arr[i];
            }
        }
        return ret1-ret2;
    }
}
