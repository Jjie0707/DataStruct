package test1;

public class Test {
    public int countGoodArrays(int n, int m, int k) {
        final int MOD=1000000007;
        long ret=1;
        int tem=Math.min(n-1-k,k);
        for(int i=n-1;i>n-1-tem;i--){
            ret*=i;
        }
        for(int i=tem;i>=1;i--){
            ret/=i;
        }
        ret*=m;
        ret%=MOD;
        for(int i=0;i<n-1-k;i++){
            ret*=(m-1);
            ret%=MOD;
        }
        return (int)ret;
    }
}
