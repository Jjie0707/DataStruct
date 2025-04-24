package test;

public class Test {
    public static void main0(String[] args) {
        int n=2;
        System.out.println(countLargestGroup(n));
    }
    public static int sum(int n){
        int ret=0;
        while(n>0){
            ret+=n%10;
            n/=10;
        }
        return ret;
    }
    public static int countLargestGroup(int n) {
        int tem=n;
        int range=0;
        while(tem>0){
            range+=9;
            tem/=10;
        }

        int[] arr=new int[range+1];
        for(int i=1;i<=n;i++){
            arr[sum(i)]++;
        }

        int max=arr[1];
        int ret=1;

        for(int i=2;i<range+1;i++){
            if(arr[i]>max){
                max=arr[i];
                ret=1;
            }else{
                if(arr[i]==max){
                    ret++;
                }
            }
        }

        return ret;
    }
}
