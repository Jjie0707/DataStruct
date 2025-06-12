package test2;

public class Test {
    public static void main(String[] args) {
        String s="1122211";
        int k=3;
        System.out.println(maxDifference(s, k));
    }
    public static int maxDifference(String S, int k) {
        int ret=-Integer.MAX_VALUE/2;
        int length=S.length();
        int[][] pre=new int[length+1][5];
        for(int i=0;i<length;i++){
            char c=S.charAt(i);
            for(int j=0;j<5;j++){
                pre[i+1][j]=pre[i][j];
            }
            pre[i+1][c-48]++;
        }
        //走到这里统计了前缀和每个字母的pre[a][i]  表示[0,i)区间a字母出现的次数
        //要求的式子是 (pre[r][a]-pre[l][a])-(pre[r][b]-pre[l][b])
        //可以变形为   (pre[r][a]-pre[r][b])-(pre[l][a]-pre[l][b])
        for (int a = 0; a < 5; a++) {
            for (int b = 0; b < 5; b++) {
                if (a == b) {
                    continue;
                }
                int[] cur=new int[5];
                int[][] min = {{Integer.MAX_VALUE / 2, Integer.MAX_VALUE / 2},
                        {Integer.MAX_VALUE / 2, Integer.MAX_VALUE / 2}};

                int left = 0;
                for (int i = 0; i < length; i++) {
                    cur[S.charAt(i)-48]++;

                    int right = i + 1;
                    int prea = pre[left][a];
                    int preb = pre[left][b];
                    while(right-left>=k && cur[a]>=prea){
                        int p=prea%2;
                        int q=preb%2;
                        int tem=pre[left][a]-pre[left][b];
                        if(min[p][q]>tem){
                            min[p][q]=tem;
                        }
                        left++;
                        prea = pre[left][a];
                        preb = pre[left][b];
                    }
                    if(right>=k){
                        int tarp = 1 - cur[a] % 2;
                        int tarq = cur[b] % 2;
                        if (cur[a] - cur[b] - min[tarp][tarq] > ret) {
                            ret = cur[a] - cur[b] - min[tarp][tarq];
                        }
                    }
                }
            }
        }
        return ret;
    }
}
