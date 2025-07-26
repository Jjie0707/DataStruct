package test0;

public class Q1 {
    public static void main(String[] args) {
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
    public  static int trap(int[] height) {
        int ret=0;
        int left=0,right=height.length-1;
        int pre_max=0,suf_max=0;
        while(left<=right){
            pre_max=Math.max(pre_max,height[left]);
            suf_max=Math.max(suf_max,height[right]);
            if(pre_max<suf_max) ret+=(pre_max-height[left++]);
            else ret+=(suf_max-height[right--]);
        }
        return ret;
    }
}
