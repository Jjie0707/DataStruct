package test0;

import java.util.ArrayList;
import java.util.Arrays;
public class Test {
    public static void main(String[] args) {
        int[] tem={2,2,8,8,2};
        System.out.println(Arrays.toString(findEvenNumbers(tem)));
    }
    public static int[] findEvenNumbers(int[] digits) {
        int[] nums = new int[10];
        int length = digits.length;
        for (int i = 0; i < length; i++) {
            nums[digits[i]] += 1;
        }
        //走到这里之后统计出了所有的数字出现的个数
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=1;i<=9;i++){
            int[] number= new int[10];
            System.arraycopy(nums,0,number,0,10);
            if(number[i]==0){
                continue;
            }
            number[i]-=1;
            for(int j=0;j<=9;j++){
                int[] number2=new int[10];
                System.arraycopy(number,0,number2,0,10);
                if(number2[j]==0){
                    continue;
                }
                number2[j]-=1;
                int tem1=i*10+j;
                for(int k=0;k<=9;k++){
                    if(number2[k]==0){
                        continue;
                    }
                    int tem2=tem1*10+k;
                    if(tem2%2==0){
                        list.add(tem2);
                    }
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
