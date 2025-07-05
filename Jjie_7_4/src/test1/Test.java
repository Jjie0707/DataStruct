package test1;

import java.util.ArrayList;

public class Test {
    public static int possibleStringCount(String word, int k) {
        int MOD = (int) (1e9 + 7);
        ArrayList<Integer> list=new ArrayList<>();
        long b=1;
        int length=word.length();
        int cur=0;
        for(int i=0;i<length;i++){
            cur++;
            if(i==length-1 || word.charAt(i+1)!=word.charAt(i)){
                if (cur > 1) {
                    list.add(cur - 1);
                    b = (b * cur) % MOD;
                }
                k--;
                cur=0;
            }
        }   //计算出了b不限制长度的所有可能情况
        if(k<1){
            return (int)b;
        }
        int m=list.size();
        int[][] f=new int[m+1][k];
        for(int i=1;i<=m;i++){
            int x=list.get(i-1);//  x为还能提供的个数
            long[] s=new long[k+1];
            for(int j=0;j<k;j++){
                s[j+1]=(s[j]+f[i-1][j])%MOD;
            }
            for(int j=0;j<k;j++){
                int l=Math.max(0,j-x);//   如果j-x<0说明可以完全提供需要的个数 则取到数组最小值
                f[i][j]=(int)((s[j+1]-s[l]+MOD)%MOD);
            }
        }
        for(int j=0;j<k;j++){
            b=(b-f[m][j]+MOD)%MOD;
        }
        return (int)b;
    }
}
