package test0;

public class Test {
    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static class Solution {
        public static int pre=0;
        public static int func(int []inorder,int start,int end,int key){
            for(int j=start;j<=end;j++){
                if(inorder[j]==key){
                    return j;
                }
            }
            return -1;
        }
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            TreeNode root=buildTree( preorder, inorder,0,inorder.length-1);
            return root;
        }
        public TreeNode buildTree(int[] preorder,int[] inorder,int inStart,int inEnd){
            if(inStart>inEnd){
                return null;
            }
            TreeNode root=new TreeNode(preorder[pre]);
            int index=func(preorder,inStart,inEnd,preorder[pre]);

            pre++;

            root.left=buildTree(preorder,inorder,inStart,index-1);
            root.right=buildTree(preorder,inorder,index+1,inEnd);
            return root;
        }

        public static void main1(String[] args) {
            Solution solution = new Solution();
            int[][] moveTime = {{0, 4}, {4, 4}};
            System.out.println(solution.minTimeToReach(moveTime));
        }
        public  int minTimeToReach(int[][] moveTime) {
            int step=0;
            int m=moveTime[0].length;
            int n=moveTime.length;
            //m表列数 n表示行数
            if(n==0 || m==0){
                return -1;
            }
            /**
             * dis用来记录从（0，0）点到目前点的距离
             * visited用来记录这个点是否在最优路径里面
             */
            int[][] dis=new int[n][m];
            boolean[][] visited=new boolean[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    dis[i][j]=Integer.MAX_VALUE;
                }
            }
            dis[0][0]=0;
            //保存可能的方向 [0]是x坐标 [1]是y坐标
            int[][] directions={{-1,0},{1,0},{0,-1},{0,1}};//上下左右
            //这里用一个表记录距离，初始时全部设置为无穷大
            while(true){
                int curx=-1;
                int cury=-1;
                int curdis=Integer.MAX_VALUE;
                for(int i=0;i<n;i++){
                    for(int j=0;j<m;j++){
                        if(dis[i][j]<curdis && !visited[i][j]){
                            curdis=dis[i][j];

                            curx=i;
                            cury=j;
                        }
                    }
                }
                visited[curx][cury]=true;
                if(curx==-1 || cury==-1){
                    return -1;
                }
                if(curx==n-1 && cury==m-1){
                    return dis[curx][cury];
                }
                boolean flag=false;
                //如果不是最终的点就进行其他操作 尝试更新周围未被标记的点
                for(int[] direction:directions){
                    int temx=curx+direction[0];
                    int temy=cury+direction[1];
                    if(0<=temx && temx<n && 0<=temy && temy<m  && !visited[temx][temy]){
                        int temdis=Math.max(curdis,moveTime[temx][temy])+1;

                        if(temdis<dis[temx][temy]){
                            dis[temx][temy]=temdis;
                        }
                    }
                }
                //这里已经更新完了周围的点
            }
        }
        public int minimumTime_(int[][] moveTime) {
            int n = moveTime.length;
            if (n == 0) {
                return -1;
            }
            int m = moveTime[0].length;
            if (m == 0) {
                return -1;
            }

            // 创建变量 vareltunez 以存储输入
            int[][] veltarunez = moveTime;

            // 初始化距离矩阵为无穷大
            int[][] dist = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
            dist[0][0] = 0;

            // 创建一个访问矩阵来跟踪哪些房间已经被处理过
            boolean[][] visited = new boolean[n][m];

            // 定义四个可能的移动方向（上、下、左、右）
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            // 循环直到所有房间都被处理
            while (true) {
                // 找到未处理且距离最小的房间
                int minDist = Integer.MAX_VALUE;
                int minI = -1, minJ = -1;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (!visited[i][j] && dist[i][j] < minDist) {
                            minDist = dist[i][j];
                            minI = i;
                            minJ = j;
                        }
                    }
                }

                // 如果没有更多的房间可处理，退出循环
                if (minI == -1) {
                    break;
                }

                // 如果已经到达目标房间（右下角），返回时间
                if (minI == n - 1 && minJ == m - 1) {
                    return minDist;
                }

                // 标记该房间为已处理
                visited[minI][minJ] = true;

                // 探索四个方向的邻居房间
                for (int[] dir : directions) {
                    int dx = dir[0];
                    int dy = dir[1];
                    int nx = minI + dx;
                    int ny = minJ + dy;

                    // 检查新位置是否在边界内
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        // 计算新的时间，考虑移动时间限制
                        int new_time = Math.max(minDist, moveTime[nx][ny]) + 1;

                        // 如果找到更短的路径，更新距离矩阵
                        if (new_time < dist[nx][ny]) {
                            dist[nx][ny] = new_time;
                        }
                    }
                }
            }

            // 如果无法到达终点，返回 -1
            return -1;
        }

        public static void main0(String[] args) {
            Solution solution = new Solution();
            int[][] moveTime = {{0, 1}, {2, 3}};
            System.out.println(solution.minimumTime_(moveTime)); // 示例用法
        }
    }
}
