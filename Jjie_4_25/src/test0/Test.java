package test0;

public class Test {
    public static void main(String[] args) {
        MinStack s=new MinStack();
        s.push(1);
        s.push(3);
        s.push(9);
        s.push(7);
        s.push(5);
        s.push(5);
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.push(9999);
        System.out.println(s.top());
    }
}
