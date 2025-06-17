package test0;

public class Test {
    public int countGoodArrays(int n, int m, int k) {
        long ret=1;
        if(k==0){
            if(n>1 && m==1){
                return 0;
            }else{
                ret=(long)(m*Math.pow(m-1,n-1));
                return (int)(ret%1000000007);
            }
        }else if(k+1>n){
            return 0;
        }


        return (int)(ret%1000000007);
    }
}
