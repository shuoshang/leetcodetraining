package com.changework;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        // 行数
        if(matrix.length ==1) {
            for(int i=0;i<matrix[0].length ;i++){
                if(matrix[0][i] == 0) {
                    matrix[0] = new int[matrix[0].length];
                }
            }
        };
        // 列数
        if(matrix[0].length==1) {
            for(int i=0;i<matrix.length ;i++){
                if(matrix[i][0] == 0) {
                    for(int j=0;j<matrix.length;j++){
                        matrix[j][0] =0;
                    }
                }
            }
        };
        List<Integer> lx  = new ArrayList<>();
        List<Integer> ly  = new ArrayList<>();
        for(int i =0;i<matrix.length ;i++){
            for(int j =0;j<matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    lx.add(i);
                    ly.add(j);
                }
            }
        }

        for(int i=0;i<lx.size();i++){
            matrix[lx.get(i)] = new int[matrix[lx.get(i)].length];
        }

        for(int i=0;i<ly.size();i++){
            for(int j=0;j<matrix.length;j++){
                matrix[j][ly.get(i)] =0;
            }
        }

    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        SetZeroes zeroes=  new SetZeroes();
        zeroes.setZeroes(nums) ;
    }
}
