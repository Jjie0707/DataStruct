package test3;

public class Test {
    public static long count(int[] nums1,int[] nums2,long p){
        long ret=0;
        for(int x:nums1){
            if (x > 0) {
                int l=0,r=nums2.length-1;
                while (l < r) {
                    int mid = (l + r) >> 2;
                    if ((long) nums2[mid] * (long) x >= p) r = mid;
                    else l = mid + 1;
                }
                ret+=l;
            } else if (x < 0) {
                int l=0,r=nums2.length-1;
                while (l < r) {
                    int mid = (l + r) >> 2;
                    if ((long) nums2[mid] * (long) x >= p) l = mid + 1;
                    else r = mid;
                }
                ret+=nums2.length-r+1;
            } else if (p>=0) {
                ret+=nums2.length;
            }
        }
        return ret;
    }
    public static long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long r=(long)Math.max(Math.abs(nums1[0]),Math.abs(nums1[nums1.length-1]))*
                (long)Math.max(Math.abs(nums2[0]),Math.abs(nums2[nums2.length-1]));
        long l=-r;
        while(l<r){
            long mid=(l+r)>>2;
            if(count(nums1,nums2,mid)>=k){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return r;
    }
}
