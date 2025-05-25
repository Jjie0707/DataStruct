package test2;

public class BinarySearchTree {
    static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int key) {
            this.key = key;
        }
    }

    public TreeNode root;

    /**
     * 插入一个元素
     */
    public boolean insert(int key) {
        if(root==null){
            root=new TreeNode(key);
        }else{
            TreeNode curp=null;
            TreeNode cur=root;
            while(cur!=null){
                curp=cur;
                if(cur.key>key){
                    cur=cur.left;
                }else if(cur.key<key){
                    cur=cur.right;
                }else{
                    return false;
                }
            }
            //走到这里说明cur==null
            if(curp.key<key){
                curp.right=new TreeNode(key);
            }else{
                curp.left=new TreeNode(key);
            }
        }
        return true;
    }

    /**
     查找key是否存在
     */
    public TreeNode search(int key) {
        TreeNode cur=root;
        while(cur!=null){
            if(key==cur.key){
                return cur;
            }else if(cur.key>key){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
        return null;
    }

    /**
     删除key的值
     分为三种情况：
     1.要删除的节点左树为空
     2.要删除的节点右树为空
     3.要删除的节点左右都不为空
     */
    public boolean remove(int key) {
        TreeNode curp=null;
        TreeNode cur=root;
        while(cur!=null){

            if(cur.key==key){
                if(cur.left==null){
                    if(curp.left==cur){
                        curp.left=cur.right;
                    }else{
                        curp.right=cur.right;
                    }
                }else if(cur.right==null){
                    if(curp.left==cur){
                        curp.left=cur.left;
                    }else{
                        curp.left=cur.left;
                    }
                }else{
                    //走到这里就是两边都不为空
                    // 替换删除 找到右边的最小值来替换
                    //右边最小值的左边一定为空
                    TreeNode tem=cur.right;
                    TreeNode temp=cur;
                    while(tem.left!=null){
                        temp=tem;
                        tem = tem.left;
                    }
                    //走到这里说明找到了右边的最小值
                    cur.key = tem.key;
                    if (cur.right == tem) {
                        cur.right = tem.right;
                    } else {
                        temp.left = tem.right;
                    }
                }
            } else if (cur.key > key) {
                curp = cur;
                cur = cur.left;
            } else {
                curp = cur;
                cur = cur.right;
            }
        }
        return false;
    }

}
