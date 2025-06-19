package test1;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        int[] fruits={3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit(fruits));
    }
    public static int totalFruit(int[] fruits) {
        int ret=-1;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int left=0,right=0;right<fruits.length;right++){
            if (map.get(fruits[right])==null) {
                map.put(fruits[right],1);
            }else{
                map.put(fruits[right],map.get(fruits[right])+1);
            }
            while(map.size()>2){
                if(map.get(fruits[left])>1){
                    map.put(fruits[left],map.get(fruits[left])-1);
                }else{
                    map.remove(fruits[left]);
                }
                left++;
            }
            ret=Math.max(ret,right-left+1);
        }
        return ret;
    }
}
