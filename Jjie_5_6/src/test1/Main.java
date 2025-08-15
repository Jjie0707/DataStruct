package test1;


import com.sun.source.tree.Tree;

import java.util.Scanner;

public class Main {
    // public static TreeNode creatTree(String s){
    //     TreeNode root=new TreeNode();
    //     char c=s.charAt(i);
    //     if(c!='#'){
    //         i++;
    //         root.val=c;
    //         root.left=creatTree(s);
    //         root.right=creatTree(s);
    //     }else{
    //         i++;
    //         root=null;
    //     }
    //     return root;
    // }
    public static int i=0;
    public static class TreeNode{
        public char val;
        public TreeNode left;
        public TreeNode right;
    }
    public static void main(String[] args) {
        String s="cf#g#ny#h#t##hpg##h#e##oebr####h##r##";
        TreeNode root=creatTree(s);
        inOrder(root);
//        f g y h t n g p h e h r b e o h c r
    }
    public static TreeNode creatTree(String s){
        TreeNode root=new TreeNode();
        char c=s.charAt(i);
        if(c!='#'){
            i++;
            root.val=c;
            root.left=creatTree(s);
            root.right=creatTree(s);
        }else{
            i++;
            root=null;
        }
        return root;
    }
    public static void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

//    public static int i=0;
//    public static class TreeNode{
//        public char val;
//        public TreeNode left;
//        public TreeNode right;
//    }
//    public static void main(String[] args) {
//        String s="abc##de#g##f###";
//        TreeNode root=creatTree(s);
//        inOrder(root);
//    }
//    public static TreeNode creatTree(String s){
//        TreeNode root=new TreeNode();
//        char c=s.charAt(i);
//        if(c!='#'){
//            i++;
//            root.val=c;
//            root.left=creatTree(s);
//            root.right=creatTree(s);
//        }else{
//            i++;
//            root=null;
//        }
//        return root;
//    }
//    public static void inOrder(TreeNode root){
//        if(root==null){
//            return;
//        }
//        System.out.print(root.val+" ");
//        inOrder(root.left);
//        inOrder(root.right);
//    }
}
