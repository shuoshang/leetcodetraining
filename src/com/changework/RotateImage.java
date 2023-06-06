package com.changework;

import java.util.Arrays;

public class RotateImage {

    public void rotate(int[][] matrix) {

        int[][] newint = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                newint[j][matrix.length-1-i] = matrix[i][j];
            }
        }
        for (int i = 0; i < newint.length; i++) {
            matrix[i] = newint[i].clone();
        }
    }

    public static void main(String[] args) {

        // write your code here
        RotateImage rotateImage =  new RotateImage();
        int[][] matrix =  new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotateImage.rotate(matrix);
        System.out.println(Arrays.toString(matrix));
    }
}
