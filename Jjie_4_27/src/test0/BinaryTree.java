package test0;

public class BinaryTree {
    public TreeNode root;
    public static class TreeNode{
        char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public static int size(TreeNode root){
        if(root==null){
            return 0;
        }
        else{
            return 1+size(root.left)+size(root.right);
        }
    }
    public BinaryTree(){
        TreeNode a=new BinaryTree.TreeNode('a');
        TreeNode b=new BinaryTree.TreeNode('b');
        TreeNode c=new BinaryTree.TreeNode('c');
        TreeNode d=new BinaryTree.TreeNode('d');
        TreeNode e=new BinaryTree.TreeNode('e');
        a.left=b;
        a.right=c;
        c.left=d;
        c.right=e;
        this.root=a;
    }
}
