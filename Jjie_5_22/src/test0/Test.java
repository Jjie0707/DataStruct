package test0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
//        int[] nums = {1,1,1,1};
//        int[][] queries = {{1,3}, {0, 2},{1,3},{1,2}};
        int[] nums={0,0,3};
        int[][] queries={ {0,2} , {1,1} , {0,0} , {0,0} };
        System.out.println(maxRemoval(nums, queries));
    }
    static class c1 implements Comparator<int[]> {
        @Override
        public  int compare(int[] o1, int[] o2) {
            return o1[0]-o2[0];
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    }
    static class c2 implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o2[1]-o1[1];
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    }
    public static  int maxRemoval(int[] nums, int[][] queries) {

        int length=nums.length;
        int q=queries.length;
        int[] diff=new int[length+1];
        ArrayList<int[] > list=new ArrayList<>();
        Arrays.sort(queries,new c1());
        //走到这里把queries按照queries[0]从小到大排好序了
        int index = 0;
        int sum =0;
        PriorityQueue<int[]> heap = new PriorityQueue<>(new c2());
        for (int i = 0; i < length; i++) {
            sum+=diff[i];
            if (nums[i] > sum) {

                //这里要创建一个queries[1]的最大堆
                while (index < q && queries[index][0] <= i) {
                    heap.offer(queries[index]);
                    index++;
                }
                //走到这里把所有queries[0]<=i的queries都加入了堆
                //并确保堆顶是最长的

                int tem=nums[i]-sum;
                if(tem>heap.size()){
                    return -1;
                }
                for(int j=0;j<tem;j++) {
                    int[] qtem = heap.poll();
                    list.add(qtem);
                    int r = qtem[1];
                    if(r>=i) {
                        sum += 1;
                    }
                    diff[r + 1] -= 1;
                }

                if(nums[i]>sum){
                    return -1;
                }
            }
        }
        return q-list.size();
    }
}
