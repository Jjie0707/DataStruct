package test0;

public class Test {
    public static void main(String[] args) {
        int[] arr={12,345,2,6,7896};
        for(int i=0;i<arr.length;i++){
            System.out.println(func());
        }
    }
    public static boolean func(int n){
        int count=0;
        while(n>0){
            count++;
            n/=10;
        }
        return (count%2)==0;
    }
    public static int findNumbers(int[] nums) {
        int ret=0;
        int length=nums.length;
        for(int i=0;i<length;i++){
            if(func(i)){
                ret++;
            }
        }
        return ret;
    }
}
