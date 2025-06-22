package test1;

public class Test {
    public static void main(String[] args) {
        String s="WEES";
        int k=2;
        System.out.println(maxDistance(s, k));
    }
    public static int maxDistance(String s, int k) {
        int ret=0;
        int N=0,S=0,E=0,W=0;
        int length=s.length();
        for(int i=0;i<length;i++){
            char c=s.charAt(i);
            if(c=='N'){
                N++;
            }else if(c=='S'){
                S++;
            }else if(c=='E'){
                E++;
            }else{
                W++;
            }
            int count=k;
            int dis=Math.abs(N-S)+Math.abs(E-W);
            if(N!=0 && S!=0){
                count-=Math.min(Math.min(N,S),k);
                dis+=2*Math.min(Math.min(N,S),k);
                if(count>0 && E!=0 && W!=0){
                    dis+=2*Math.min(count,Math.min(E,W));
                }
            }else if(E!=0 && W!=0){
                count-=Math.min(Math.min(W,E),k);
                dis+=2*Math.min(Math.min(W,E),k);
                if(count>0 && N!=0 && S!=0){
                    dis+=2*Math.min(count,Math.min(N,S));
                }
            }
            ret=Math.max(ret,dis);
        }
        return ret;
    }
}
