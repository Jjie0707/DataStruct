package test1;

public class SearchTree {
    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode root;

    public boolean add(int val){
        if(root==null){
            //如果搜索树为空，则直接构建出一颗新的树
            root=new TreeNode(val);
        }else{
            TreeNode curp=null;
            TreeNode cur=root;
            while(cur!=null){
                if(cur.val>val){
                    curp=cur;
                    cur=cur.left;
                }else if(cur.val<val){
                    curp=cur;
                    cur=cur.right;
                }else{
                    return false;
                }
            }
            //走到这里cur==null，说明走到了相对应的位置
            if(curp.val>val){
                curp.left=new TreeNode(val);
            }else{
                curp.right=new TreeNode(val);
            }
        }
        return true;
    }

    public boolean poll(int key){
        if(root==null){
            return false;
        }
        TreeNode curp=null;
        TreeNode cur=root;
        while(cur!=null){
            if(cur.val>key){
                curp=cur;
                cur=cur.left;
            }else if(cur.val<key){
                curp=cur;
                cur=cur.right;
            }else{
                //走到这里说明找到了要删除的节点
                //分三种情况讨论
                if(cur.left==null){
                    if(curp.right==cur){
                        curp.right=cur.right;
                    }else{
                        curp.left=cur.right;
                    }
                    return true;
                }else if(cur.right==null){
                    if(curp.right==cur){
                        curp.right=cur.left;
                    }else{
                        curp.left=cur.left;
                    }
                    return true;
                }else{
                    //  cur.left!=null && cur.right!=null
                    //   这个时候我们用替换删除,即找到 左边的最大值 或者 右边的最小值
                    TreeNode temp=cur;
                    TreeNode tem=cur.right;
                    while(tem.left!=null){
                        //只要tme的左树不空就不是最小值{
                        temp=tem;
                        tem=tem.left;
                    }
                    //走到这里找到了右边的最小值
                    if(cur.right==tem){
                        cur.right=tem.right;
                        return true;
                    }
                    cur.val=tem.val;
                    temp.left=null;
                }
            }
        }
        return false;
    }
}
