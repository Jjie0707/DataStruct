package test0;

import java.util.Arrays;

public class Q2 {
    public static void main(String[] args) {
        int[][] matrix={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
        for(int[] tem:matrix){
            System.out.println(Arrays.toString(tem));
        }
    }
    public static void setZeroes(int[][] matrix) {
        int tem=1;//用来标记第一行是否要置为0
        int l=matrix.length,w=matrix[0].length;
        for(int i=0;i<l;i++){
            for(int j=0;j<w;j++){
                if(matrix[i][j]==0){
                    if(i>0) {
                        matrix[0][j]=0;
                        matrix[i][0]=0;
                    }else{
                        tem=0;
                    }
                }
            }
        }
        if(tem==0){
            for (int j = 0; j < w; j++) {
                matrix[0][j]=0;
            }
        }
        for(int i=1;i<l;i++){
            for(int j=0;j<w;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0) matrix[i][j]=0;
            }
        }
    }
}
