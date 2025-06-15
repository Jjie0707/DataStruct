package test0;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println(minMaxDifference(11891));
    }
    public static int[] func(int n){
        int count=0;
        int tem=n;
        while(tem>0){
            count++;
            tem/=10;
        }
        //321
        int[] ret=new int[count];
        while(n>0){
            ret[count-1]=n%10;
            n/=10;
            count--;
        }
        return ret;
    }
    public static int minMaxDifference(int num) {
        int[] arr =func(num);
        boolean flag=false;
        int key=0;
        int max=0;
        for(int i=0;i<arr.length;i++){
            if(flag){
                if(arr[i]==key){
                    max=max*10+9;
                }else{
                    max=max*10+arr[i];
                }
            }else{
                if(arr[i]!=9){
                    flag=true;
                    key=arr[i];
                    max=max*10+9;
                }else{
                    max=max*10+arr[i];
                }
            }
        }
        int min=0;
        for(int i=0;i< arr.length;i++){
            if(i==0){
                key=arr[0];
                continue;
            }else{
                if(arr[i]==key){
                    min=min*10;
                }else{
                    min=min*10+arr[i];
                }
            }
        }
        return max-min;
    }
}
