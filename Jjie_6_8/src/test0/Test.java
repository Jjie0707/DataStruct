package test0;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int n=13;
        for(int i:lexicalOrder(n)){
            System.out.print(i+" ");
        }
    }
    public static void func(ArrayList<Integer> list,int i,int n){
        if(i<=n) {
            list.add(i);
            for(int j=0;j<=9;j++){
                func(list,10*i+j,n);
            }
        }else{
            return ;
        }

    }
    public static List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> ret=new ArrayList<Integer>();
        for(int i=1;i<=9;i++){
            func(ret,i,n);
        }
        return ret;
    }
}
