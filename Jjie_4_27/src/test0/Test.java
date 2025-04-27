package test0;

public class Test {
    public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();
        System.out.println(BinaryTree.size(tree.root));
        System.out.println(BinaryTree.size(tree.root.right));
        System.out.println(BinaryTree.size(tree.root.left));
        System.out.println(BinaryTree.size(tree.root.right.left));
    }
}
