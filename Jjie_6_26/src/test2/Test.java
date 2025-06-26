package test2;

import java.util.PriorityQueue;
//    输入：nums1 = [-4,-2,0,3], nums2 = [2,4], k = 6
//    输出：0
//    解释：第 6 小的乘积计算如下：
//            - nums1[0] * nums2[1] = (-4) * 4 = -16
//            - nums1[0] * nums2[0] = (-4) * 2 = -8
//            - nums1[1] * nums2[1] = (-2) * 4 = -8
//            - nums1[1] * nums2[0] = (-2) * 2 = -4
//            - nums1[2] * nums2[0] = 0 * 2 = 0
//            - nums1[2] * nums2[1] = 0 * 4 = 0
//    第 6 小的乘积为 0 。
public class Test {
    public static void main(String[] args) {
        int[] nums1={2,5},nums2={3,4};
        long k=2;
        System.out.println(kthSmallestProduct(nums1, nums2, k));
    }
    public static long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long count = k;
        PriorityQueue<Long> heap = new PriorityQueue<>((e1, e2) -> e2.compareTo(e1));
        for (int i = 0; i < nums1.length; i++) {
            long tem = 0;
            if (nums1[i] >= 0) {
                //                nums1[i]>=0,从最小的开始找
                int j = 0;
                while (count > 0 && j < nums2.length) {
                    tem = (long) nums1[i] * (long) nums2[j];
                    heap.offer(tem);
                    count--;
                    j++;
                    if (j < nums2.length) tem = (long) nums1[i] * (long) nums2[j];
                }
                if (j < nums2.length) tem = (long) nums1[i] * (long) nums2[j];
                while (tem < heap.peek() && j < nums2.length) {
                    heap.poll();
                    heap.offer(tem);
                    j++;
                    if (j < nums2.length) {
                        tem = (long) nums1[i] * (long) nums2[j];
                    } else {
                        break;
                    }
                }
            } else {
                //                nums1[i]<0,此时从最大的开始找
                int j = nums2.length-1;
                while (count > 0 && j>=0) {
                    tem = (long) nums1[i] * (long) nums2[j];
                    heap.offer(tem);
                    count--;
                    j--;
                    if (j>=0) tem =(long) nums1[i] * (long) nums2[j];
                }
                if (j>=0) tem =(long) nums1[i] * (long) nums2[j];
                while (tem < heap.peek() && j>=0) {
                    heap.poll();
                    heap.offer(tem);
                    j--;
                    if (j>=0) {
                        tem = (long) nums1[i] * (long) nums2[j];
                    } else {
                        break;
                    }
                }
            }
        }
        return heap.peek();
    }
//    public static long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
//        long count=k;
//        PriorityQueue<Long> heap=new PriorityQueue<>((e1,e2)->e2.compareTo(e1));
//        for(int i=0;i<nums1.length;i++){
//            long tem=0;
//            if(nums1[i]>=0){
//                int j=0;
//                while(nums2[j]<=0){
//                    tem=(long)nums1[i]*(long)nums2[j];
//                    if(count>0){
//                        heap.offer(tem);
//                        count--;
//                    }else{
//                        if(heap.peek()>tem){
//                            heap.poll();
//                            heap.offer(tem);
//                        }
//                    }
//                    j++;
//                }
//            }else{
//                //nums1[i]<0
//                int j=nums2.length-1;
//                while(nums2[j]>=0){
//                    tem=(long)nums1[i]*(long)nums2[j];
//                    if(count>0){
//                        heap.offer(tem);
//                        count--;
//                    }else{
//                        if(heap.peek()>tem){
//                            heap.poll();
//                            heap.offer(tem);
//                        }
//                    }
//                    j--;
//                }
//            }
//        }
//        return heap.peek();
//    }

//
//    public static long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
//        long count = k;
//        PriorityQueue<Long> heap = new PriorityQueue<>((e1, e2) -> e2.compareTo(e1));
//        for (int i = 0; i < nums1.length; i++) {
//            for (int j = 0; j < nums2.length; j++) {
//                long tem = (long) nums1[i] * (long) nums2[j];
//                if (count > 0) {
//                    heap.offer(tem);
//                    count--;
//                } else {
//                    if (tem < heap.peek()) {
//                        heap.poll();
//                        heap.offer(tem);
//                    }
//                }
//            }
//        }
//        return heap.peek();
//    }

}
