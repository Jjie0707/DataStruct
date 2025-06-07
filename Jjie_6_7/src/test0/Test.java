package test0;

import java.util.HashSet;

public class Test {
    public static void main(String[] args) {

    }

    public static String clearStars(String s) {
        StringBuilder ans=new StringBuilder(s);
        int[] words=new int[26];
        int length= s.length();
        int count=0;
        for (int i = 0; i < length; i++) {
            char c=s.charAt(i);
            if(c!='*'){
                words[c-97]++;
            }else{
                count++;
            }
        }
        if(count==0){
            return s;
        }
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<length;i++){
            char c=s.charAt(i);
            if(c=='*'){
                for(int j=i-1;j>=0;j++){

                }
            }
        }
    }
}
