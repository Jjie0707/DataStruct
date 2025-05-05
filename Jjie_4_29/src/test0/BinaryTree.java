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

    public static int size(TreeNode root){
        if(root==null){
            return 0;
        }
        else{
            return 1+size(root.left)+size(root.right);
        }
    }

    //第k层有多少个节点
    public int func(TreeNode root,int k){
        if(root==null){
            return 0;
        }
        if(k==1){
            return 1;
        }else{
            return func(root.left,k-1)+func(root.right,k-1);
        }
    }

    //叶子节点的数目
    public int func0(TreeNode root){
        if(root.left==root.right){
            return 1;
        }else{
            return func0(root.left)+func0(root.right);
        }
    }

    //统计🌲的高度
    public int func1(TreeNode root){
        if(root==null){
            return 0;
        }else{
            return 1+Math.max(func1(root.left),func1(root.right));
        }
    }

    //寻找特定的值
    public TreeNode find(TreeNode root,char val){
        if(root==null){
            return null;
        }
        if(root.val==val){
            return root;
        }
        TreeNode left=find(root.left,val);
        if(left!=null){
            return left;
        }
        return find(root.right,val);
    }
}
