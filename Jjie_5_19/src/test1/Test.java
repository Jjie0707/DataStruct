package test1;

public class Test {
    public static void main0(String[] args) {
        SearchTree root=new SearchTree();
        root.add(3);
        root.add(5);
        root.add(4);
        root.add(7);
        root.add(6);
        root.add(1);
        root.poll(7);
        System.out.println(6);
    }
}
