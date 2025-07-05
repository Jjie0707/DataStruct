package test0;

public class Test {
    public static void main(String[] args) {
        String word1="aaabbb";
        int k1=3;
        String word2="aabbccd";
        int k2=6;
        String word = "aabbccdd";
        int k = 7;

        System.out.print(possibleStringCount(word1, k1));
        System.out.println(" "+8);
        System.out.print(possibleStringCount(word2, k2));
        System.out.println(" "+3);
        System.out.print(possibleStringCount(word, k));
        System.out.println(" "+5);
    }
    public char kthCharacter(long k, int[] operations) {
        return 'a';
    }
    public static int possibleStringCount(String word, int k) {
        int MOD = (int) (1e9 + 7);
        long ret = 0;
        int length = word.length();

        if (length == k) return 1;
        else if (length < k) return 0;

        int[] words = new int[26];
        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);
            words[c - 'a']++;
        }
        int count = 0, count1 = 0;//count统计超过一次的字符
        for (int i = 0; i < 26; i++) {
            if(words[i]>1){
                count++;
                count1++;
            }else if(words[i]==1){
                count1++;
            }
        }
        int dif=k-count1;
        if(dif<=0){
            return (int)(Math.pow(2,count)-1);
        }
        int fac=1;
        for(int i=count;i>count-dif;i--){
            fac*=i;
        }
        for(int i=dif;i>=1;i--){
            fac/=i;
        }
        for(int i=0;i<26;i++){
            if(words[i]>1){
                if(dif>0){
                    if(words[i]!=2){
                        ret=(ret+(words[i]-1)*fac%MOD)%MOD;
                    }
                    dif--;
                }else{
                    ret=(ret+fac*(words[i])%MOD)%MOD;
                }
            }
        }
        return (int)ret;
    }
}
