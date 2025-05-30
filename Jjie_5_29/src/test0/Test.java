package test0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        try {
            Class c=Class.forName("/Users/ouyangjunjie/Desktop/GitHub/DataStruct/Jjie_5_29/src/test0/Student.java");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public static void main3(String[] args) {
//        int[] nums={2,6,9,1,3,7,4,8,5};
        int[] nums={1,1,1,1,1,1,1,1,1};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void quickSort(int[] nums){
        quick(nums,0,nums.length-1);
    }
    public static void quick(int[] nums,int start,int end){
        if(start>=end){
            return ;
        }

        int left=start;
        int right=end;

        int pit=par(nums,left,right);
        quick(nums,start,pit-1);
        quick(nums,pit+1,end);
    }
    public static int par(int[] nums,int start,int end){
        getMid(nums,start,end);
        int key=nums[start];
        int left=start;
        int right=end;
        while(left<right){
            while(left<right && nums[right]>=key){
                right--;
            }//走到这里说明一定nums[right]<key
            while(left<right && nums[left]<=key){
                left++;
            }
            swap(nums,left,right);
        }
        swap(nums,start,left);
        return left;
    }
    public static void getMid(int[] nums,int left,int right){
        int mid=(left+right)/2;
        if(nums[left]>=nums[right]){
            //  left>right>mid
            if(nums[right]>nums[mid]){
                swap(nums,left,right);
            // left>mid>right
            }else if(nums[left]>nums[mid]){
                swap(nums,left,mid);
            }
        }else{
            // mid>right>left
            if(nums[mid]>nums[right]){
                swap(nums,left,right);
            }else if(nums[mid]>nums[left]){
                //right>mid>left
                swap(nums,left,mid);
            }
            //right>left>mid
        }
    }
    public static void swap(int[] nums,int e1,int e2){
        int tem=nums[e1];
        nums[e1]=nums[e2];
        nums[e2]=tem;
    }
    public static void main2(String[] args) {
        // 默认建立了一个小堆，堆顶是最小值
//        PriorityQueue<Integer> heap=new PriorityQueue<>();
//        heap.offer(3);
//        heap.offer(6);
//        heap.offer(7);
//        heap.offer(5);
//        heap.offer(3);
//        int size=heap.size();
//        for(int i=0;i<size;i++){
//            System.out.print(heap.poll());
//        }
        //利用比较器有参构造建立一个大堆
        PriorityQueue<Integer> heap=new PriorityQueue<>((o1,o2)->o2.compareTo(o1));
        heap.offer(3);
        heap.offer(6);
        heap.offer(7);
        heap.offer(5);
        heap.offer(3);
        int size=heap.size();
        for(int i=0;i<size;i++){
            System.out.print(heap.poll());
        }
    }
    public static void main1(String[] args) {
        PriorityQueue<Character> heap=new PriorityQueue<>();
        List<Integer> list=new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(6);
        list.add(2);
        Integer[] arr=list.toArray(new Integer[0]);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void main0(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(6);
        list.add(3);
        list.add(5);
        list.add(4);
        list.add(1);
//        System.out.println(list.contains(4));
        Integer tem=4;
        list.remove(tem);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
