package test0;

public class Test {
    public static void main(String[] args) {
        int[] tops={1,2,1,1,1,2,2,2};
        int[] bottoms={2,1,2,2,2,2,2,2};
        System.out.println(minDominoRotations(tops,bottoms));
    }
    public static int minDominoRotations(int[] tops, int[] bottoms) {
        int target_top=tops[0];
        int target_bottom=bottoms[0];

        int ret_top=func(tops,bottoms,target_top);
        int ret_bottom=func(tops,bottoms,target_bottom);
        if(ret_bottom==-1 && ret_top==-1){
            return -1;
        }else if(ret_bottom!=-1 && ret_top==-1){
            return ret_bottom;
        }else if(ret_bottom==-1){
            return ret_top;
        }else{
            return Math.min(ret_bottom,ret_top);
        }
    }
    public static int func(int[] tops,int[] bottoms,int target){
        int length=tops.length;
        int ret_top=0;
        int ret_bottom=0;
        for(int i=0;i<length;i++){
            int top=tops[i];
            int bottom=bottoms[i];

            if(top!=target && bottom!=target){
                return -1;
            }else if(top!=target){
                ret_top+=1;
            }else if(bottom!=target){
                ret_bottom+=1;
            }

        }
//        if(ret_bottom==-1 && ret_top==-1){
//            return -1;
//        }else if(ret_bottom==-1){
//            return ret_top;
//        }else if(ret_top==-1){
//            return ret_bottom;
//        }
        return Math.min(ret_bottom,ret_top);
    }
}
