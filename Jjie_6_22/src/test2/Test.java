package test2;

public class Test {
    public static String[] divideString(String s, int k, char fill) {
        int j=0;
        int length=s.length();
        int n=length/3+(length%3==0 ? 0 : 1);
        String[] ret=new String[n];
        for(int i=0;i<length;i+=3){
            if(i+3>length){
                StringBuilder tem=new StringBuilder(s.substring(i));
                int length1= tem.length();;
                for(int h=0;h<3-length1;h++){
                    tem.append(fill);
                }
                ret[j++]=tem.toString();
            }else{
                ret[j++]=s.substring(i,i+3);
            }
        }
        return ret;
    }
}
