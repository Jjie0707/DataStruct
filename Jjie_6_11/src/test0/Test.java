package test0;

public class Test {
    public static void main(String[] args) {
//        System.out.println('0'+1); 49
        String s="110";
        int k=3;
        System.out.println(maxDifference(s, k));
    }
    public static int max(int[] words) {
        int max=0;
        for(int i=0;i<5;i++){
            if(words[i]>max && words[i]%2==1){
                max=words[i];
            }
        }
        return max;
    }
    public static int min(int[] words){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<5;i++){
            if(words[i]<min && words[i]!=0 && words[i]%2==0){
                min=words[i];
            }
        }
        return min;
    }
    public static int maxDifference(String s, int k) {
        int ret=Integer.MIN_VALUE;
        int length=s.length();
        for(int i=0;i<length-k+1;i++){
            int[] words=new int[5];

            char c=0;
            for(int j=0;j<k;j++){
                c=s.charAt(j+i);
                words[c-48]++;
            }
            int max=max(words);
            int min=min(words);
            if(min!=Integer.MIN_VALUE && max!=0 && max-min>ret){
                ret=max-min;
            }
            for(int j=i+k;j<length;j++){
                c=s.charAt(j);
                words[c-48]++;
                max=max(words);
                min=min(words);
                if(min!=Integer.MIN_VALUE && max!=0 && max-min>ret){
                    ret=max-min;
                }
            }
        }
        return ret;
    }
}
