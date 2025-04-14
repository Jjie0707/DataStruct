package test0;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println(countGoodNumbers(4));
    }
    public static int countGoodNumbers(long n) {
        int k=(int)Math.pow(10,9)+7;
        //偶数位的数量n1
        int n1=(int)((n+1)/2);
        int n2=(int)(n-n1);
        //奇数位的数量n2
        long count=1;
        count=(long)(count*(Math.pow(5,n1))*(Math.pow(4,n2)));
        return (int)(count % k);
    }
    public static void main3(String[] args) {
        int count=countGoodNumlbers(4);
        System.out.println(count);
    }
    public static boolean func(int n){
        switch(n){
            case 2:
            case 3:
            case 5:
            case 7:{
                return true;
            }
            default:
                return false;
        }
    }
    public static boolean check(int n){
        StringBuilder sb=new StringBuilder(n+"");
        String s=sb.toString();
        int length=s.length();
        for(int i=0;i<length;i++){
            if(i%2==0){
                if((s.charAt(i)-48)%2!=0){
                    return false;
                }
            }else{
                if(!func(s.charAt(i)-48)){
                    return false;
                }
            }
        }
        return true;
    }
    public static int countGoodNumlbers(long n) {
        int count=0;
        for(int i=(int)Math.pow(10,n-1); i< (int)Math.pow(10,n); i++){
            if(check(i)){
                count++;
            }
        }
        count++;
        return count%1000000007;
    }



    public static void main1(String[] args) {
        StringBuilder sb=new StringBuilder(2+"");
        sb.reverse();
    }
    //arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
    //arr = [1,1,2,2,3], a = 0, b = 0, c = 1
    public static void main0(String[] args) {
        int[] arr={7,3,7,3,12,1,12,2,3};//7,3,7,3,12,1,12,2,3]
        int count=countGoodTriplets(arr,5,8,1);
        System.out.println(count);
    }
    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count=0;
        int length=arr.length;
        int j=0;
        int k=0;
        for (int i = 0; i < length - 1; i++) {
            j = i + 1;
            while (j < length - 1) {
                k = j + 1;
                while (k < length &&
                        (Math.abs(arr[i] - arr[j])) <= a) {
                    if ((Math.abs(arr[k] - arr[j])) <= b &&
                            (Math.abs(arr[k] - arr[i])) <= c) {
                        count++;
                    }
                    k++;
                }
                j++;
            }
        }
        return count;
//        Arrays.sort(arr);
//        int count=0;
//        int length=arr.length;
//        int j=0;
//        int k=0;
//        for(int i=0;i<length-2;i++){
//            j=i+1;
//            while(j<length-1 && Math.abs(arr[j]-arr[i])<=a){
//                k=j+1;
//                while(k<length){
//                    if(Math.abs(arr[k]-arr[j])<= b
//                            && Math.abs(arr[k]-arr[i])<= c) {
//                        count++;
//                        k++;
//                    }else{
//                        break;
//                    }
//                }
//                j++;
//            }
//        }
//        return count;
    }
}
