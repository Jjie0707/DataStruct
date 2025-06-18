package test0;

public class Test {
//    public static double myPow(double x, int n) {
//        if(n<0){
//            x=1/x;
//        }
//        double ans=1;
//        while(n>0){
//            if((n&1)==1){
//                ans*=x;
//            }
//            x*=x;
//            n/=2;
//        }
//        return ans;
//    }
public static final int MOD = 1000000007;
    public static long[] fac = new long[100000];
    public static long[] ffac = new long[100000];
    public static  boolean flag = false;

    public int countGoodArrays(int n, int m, int k) {
        init();
        return (int) (func(k,n-1)*m%MOD*myPow(m-1,n-k-1)%MOD);
    }
    public static long func(int a,int b){
        return fac[b]*ffac[a]%MOD*ffac[b-a]%MOD;
    }
    public static void init() {
        if(!flag){
            flag=true;
            fac[0] = 1;
            for (int i = 1; i < 100000; i++) {
                fac[i] = fac[i - 1] * i %MOD;
            }
            ffac[99999]=myPow(fac[99999],MOD-2);
            for(int i=99999;i>0;i--){
                ffac[i-1]=ffac[i]*i%MOD;
            }
        }
    }
    public static long myPow(long x, int n) {
        long N=n;
        long ans=1;
        while(N>0){
            if((N&1)==1){
                ans=ans*x%MOD;
            }
            x=x*x%MOD;
            N/=2;
        }
        return ans;
    }
}
