package test0;

public class Test {
    public static int longestSubsequence(String s, int k) {
        int l=0,length=s.length(),sum=0;
        for(int i=length-1;i>=0;i--){
            char c=s.charAt(i);
            if(c=='0') l++;
            else {
                if (sum + Math.pow(2, l) <= k){
                    sum+=Math.pow(2,l);
                    l++;
                }
            }
        }
        return l;
    }
}
