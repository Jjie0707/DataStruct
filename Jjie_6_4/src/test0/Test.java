package test0;

public class Test {
    public static void main(String[] args) {
        String word = "aann";
        int numFriends = 2;
        System.out.println(answerString(word, numFriends));
    }
    public static String answerString(String word, int numFriends) {
        int length=word.length();
        int ret=-1;
        char max=0;
        for(int i=0;i<length;i++){
            if(word.charAt(i)>max){
                ret=i;
                max = word.charAt(i);
            } else if (word.charAt(i) == max) {
                if (length > numFriends) {
                    //如果新的字典序更大，再更新
                    int end1=ret+length-numFriends+1;
                    String str1="";
                    if(end1>=length){
                        str1=word.substring(ret);
                    }else{
                        str1=word.substring(ret,end1);
                    }

                    int end2=i+length-numFriends+1;
                    String str2="";
                    if(end2>=length){
                        str2=word.substring(i);
                    }else{
                        str2=word.substring(i,end2);
                    }

                    if(str2.compareTo(str1)>0){
                        ret=i;
                    }
                }
            }
        }
        if(length>numFriends){
            if(ret+length-numFriends+1>=length){
                return word.substring(ret);
            }else{
                return word.substring(ret,ret+length-numFriends+1);
            }

        }else{
            return max+"";
        }
    }
    public static String answerString_(String word, int numFriends) {
        int length=word.length();
        int[] str=new int[length];
        int pre=0;
        char max=0;
        for(int i=0;i<length;i++){
            if(word.charAt(i)>max){
                max=word.charAt(i);
            }
            pre+=word.charAt(i);
            str[i]=pre;
        }
        //走到这里统计完成了每个位置字符的前缀字符串字典序的和
        if(length>numFriends){
            int len=length-numFriends+1;//最长的字符串能有的长度
            int ret=0;
            int tem=0;
            for(int i=0;i<length-len+1;i++){
                if((str[i+len-1]-str[i]+word.charAt(i) )> tem){
                    tem=str[i+len-1]-str[i]+word.charAt(i);
                    ret=i;
                }
            }
            StringBuilder ans=new StringBuilder();
            for(int i=0;i<len;i++){
                ans.append(word.charAt(ret+i));
            }
            return ans.toString();
        }else{
            return (max+"");
        }
    }
}
