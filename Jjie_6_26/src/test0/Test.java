package test0;

public class Test {
    public static void main(String[] args) {
        int k=5,n=15;
        System.out.println(kMirror(k, n));
    }
    public static boolean func(int k,int num){
        StringBuilder tem=new StringBuilder("");
        int t=num;
        while(t>0){
            tem.append(t%k);
            t/=k;
        }
        int left=0,right=tem.length()-1;
        while(left<right){
            if(tem.charAt(left)!=tem.charAt(right)) return false;
            left++;right--;
        }
        return true;
    }
    public static long kMirror(int k, int n) {
        long ret=0;
        for(int l=1;;l++){
                int left = (int) Math.pow(10, l / 2);
                int right = (int) Math.pow(10, l / 2 + 1);
                for (int x = left; x < right; x++) {
                    long num = x;
                    int tem = x;
                    tem = l % 2 == 0 ? tem : x / 10;
                    while (tem > 0) {
                        num = num * 10 + tem % 10;
                        tem /= 10;
                    }
                    if(n>=0){
                        if(func(k,(int)num)){
                            ret+=num;
                            n--;
                        }
                    }else{
                        return ret;
                    }
                }
        }
    }
//    long ret=0;
//        int i=1;
//        while(n>0){
//            if(func(k,i) && func(10,i)){
//                ret+=i;
//                n--;
//            }
//            i++;
//        }
//        return ret;
}
