package test1;

public class Test {
    public static void main(String[] args) {
        String s="Hello how are you Contestant";
        int k=4;
        System.out.println(truncateSentence(s, k));
    }
    public static String truncateSentence(String s, int k) {
        int start=0,length=s.length();
        int i=0;
        for(;i<length;i++){
            if(s.charAt(i)==' ') k--;
            if(k<=0) break;
        }
        return s.substring(start,i);
    }
}
