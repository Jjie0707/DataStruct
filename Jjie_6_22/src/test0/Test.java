package test0;

public class Test {
    public static void main(String[] args) {
         String s= "NWSE";
         int k = 1;
        System.out.println(maxDistance(s, k));
    }
    public static int maxDistance(String s, int k) {
        int ret=0;
        char prex=0;
        char prey=0;
        int length=s.length();
        int x=0,y=0;
        for(int i=0;i<length;i++){
            char c=s.charAt(i);
            if(c=='N' || c=='S'){
                if(prey==0){
                    prey=c;
                    y+=(c=='N' ? 1 : -1);
                }else{
                    if(c==prey || c!=prey && k<=0){
                        y+=(c=='N' ? 1 : -1);
                    }else{
                        y+=(y<=0 ? -1 :1);
                        k--;
                    }
                }
            }else{
                if(prex==0){
                    prex=c;
                    x+=(c=='E' ? 1 : -1);
                }else{
                    if(c==prex || c!=prex && k<=0){
                        x+=(c=='E' ? 1 : -1);
                    }else{
                        x+=(x<=0 ? -1 :1);
                        k--;
                    }
                }
            }
            ret=Math.max(ret,Math.abs(x)+Math.abs(y));
        }
        return ret;
    }
}
