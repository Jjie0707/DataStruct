package test3;

public class Test {
    public static void main(String[] args) {
        String s="wew";
        System.out.println(possibleStringCount(s));
    }
    public static int possibleStringCount(String s) {
        int length=s.length();
        int ret=1;
        for(int i=0;i<length;i++){
            char c=s.charAt(i);
            while(i+1<length && s.charAt(i+1)==c){
                i++;ret++;
            }
        }
        return ret;
    }
}
