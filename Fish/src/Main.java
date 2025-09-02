
import test0.Pools;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Pools pools=new Pools();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入鱼塘的数量:(2 ≤ size ≤ 25)");
        int size=sc.nextInt();
        System.out.println("请输入小明拥有的总时间(单位小时)：");
        int time= sc.nextInt();
        pools.fish(size,time);
    }
}
