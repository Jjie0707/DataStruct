package test0;

public class Test {
    class Solution {
        public static boolean check(int[] arr,int start,int end,int k){
            /*
            git branch dev    //新建一个分支--1
            git checkout dev  //切换到分支--2
            git checkout -dev       //切换到分支b，相当于上面1和2
            git switch dev        (替代 git checkout)
            git switch -c dev     (替代 git checkout -b)

            git branch -d testing    //删除本地分支
            git branch -m oldName newName   //分支重命名
            git push --delete origin oldName    //删除远程分支
            git push origin newName                //上传新命名的本地分支

            git reset --soft commit_id             //撤销commit,将改动放在缓存区(不撤销git add .)
            git reset --soft HEAD^/HEAD~1/HEAD~2,  //撤销commit,修改保留
            git reset --mixed commit_id            //撤销commit,不把改动放在缓存区(撤销git add .)
            git reset --hard commit_id             //撤销commit,但是不会保留修改
            git reset --hard                       //撤销对文件的修改(已暂存)

            git checkout -- fileName    //撤销对某个文件的修改(未暂存)
            git checkout -- .           //撤销工作区下所有文件的修改
            git restore                   (替代 git checkout --)
            git restore <file>            //将在工作区但是不在暂存区的文件撤销更改
            git restore --staged <file>   //从暂存区中恢复至work tree，不会撤销更改
            git restore --staged .        //将当前目录所有暂存区文件恢复状态
            git restore --worktree <file> //撤销工作区下某文件的修改
            git restore --worktree .      //撤销工作区下所有文件的修改
            */

            int count=0;
            for(int i=start;i<=end;i++){
                for(int j=i;j<=end;j++){
                    if(arr[i]==arr[j]){
                        count++;
                    }
                    if(count>=k){
                        return true;
                    }
                }
            }
            return count==k;
        }
        // public long countGood(int[] nums, int k) {
        //     long count=0;

        //     int length=(int)((2*k+1)/2);
        //     int left=0;
        //     int right=left+length;

        //     int end=nums.length-1;
        //     while(true){
        //         while(!check(nums,left,right))
        //     }
        // }
    }
}
