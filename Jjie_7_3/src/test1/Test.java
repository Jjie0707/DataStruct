package test1;

public class Test {
    public static void main(String[] args) {
        System.out.println(kthCharacter(10));
    }
    public static char kthCharacter(int k) {
        StringBuilder ans=new StringBuilder("a");
        while(ans.length()<=k){
            StringBuilder tem=new StringBuilder();
            int length=ans.length();
            for(int i=0;i<length;i++){
                if(ans.charAt(i)!='z'){
                    tem.append( (char)(ans.charAt(i)+1) );
                }else tem.append('a');
            }
            ans.append(tem);
        }
        return ans.charAt(k-1);
    }
}
