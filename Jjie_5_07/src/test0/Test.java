package test0;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Test {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //需要被返回的列表
        ArrayList<List<Integer>> list=new ArrayList<>();
        //用来完成操作的队列
        LinkedList<TreeNode> q=new LinkedList<>();
        q.addLast(root);
        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer> tem=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node =q.removeFirst();
                tem.add(node.val);
                if(node.left!=null){
                    q.addLast(node.left);
                }
                if(node.right!=null){
                    q.addLast(node.right);
                }
            }
            list.add(tem);
        }
        return list;
    }
    public static void main0(String[] args) {

    }
    public static class TreeNode{
        public int val;
        TreeNode left;
        TreeNode right;
    }
    public static boolean func(TreeNode root, TreeNode p, Stack<TreeNode> s){
        if(root==null){
            return false;
        }
        s.push(p);
        if(root.val==p.val){
            return true;
        }
        boolean left = func(root.left,p,s);
        if(left){
            return true;
        }
        boolean right = func(root.right,p,s);
        if(!right){
            s.pop();
            return false;
        }
        return true;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val==p.val || root.val==q.val){
            return root;
        }

        Stack<TreeNode> s1=new Stack<>();
        Stack<TreeNode> s2=new Stack<>();

        func(root,p,s1);
        func(root,q,s2);

        //这里假设已经用两个栈把 这两个节点的路径保存了下来
        int size1=s1.size();
        int size2=s2.size();

        Stack<TreeNode> s=size1>size2 ? s1 :s2;

        for(int i=0;i<Math.abs(size1-size2);i++){
            s.pop();
        }

        while( s1.peek().val!=s2.peek().val){
            s1.pop();
            s2.pop();
        }

        //走到这里找到了相交的节点

        return s1.peek();
    }
}
