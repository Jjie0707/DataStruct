package test0;

public class Test {
    public static void main0(String[] args) {
        BinaryTree tree=new BinaryTree();
        System.out.println(tree.func(tree.root,1));
        System.out.println(tree.func(tree.root,2));
        System.out.println(tree.func(tree.root,3));
    }

    public static void main1(String[] args) {
        BinaryTree tree=new BinaryTree();
        System.out.println(tree.func0(tree.root));
    }

    public static void main2(String[] args) {
        BinaryTree tree=new BinaryTree();
        System.out.println(tree.func1(tree.root));
        System.out.println(tree.func1(tree.root.left));
        System.out.println(tree.func1(tree.root.right));
    }

    public static void main3(String[] args) {
        BinaryTree tree=new BinaryTree();
        BinaryTree.TreeNode tem1=tree.find(tree.root,'a');
        if (tem1!=null) {
            System.out.println(tem1.val);
        }else{
            System.out.println("null");
        }
        BinaryTree.TreeNode tem2=tree.find(tree.root,'f');
        if (tem2!=null) {
            System.out.println(tem2.val);
        }else{
            System.out.println("null");
        }
        BinaryTree.TreeNode tem3=tree.find(tree.root,'c');
        if (tem3!=null) {
            System.out.println(tem3.val);
        }else{
            System.out.println("null");
        }
    }
}
