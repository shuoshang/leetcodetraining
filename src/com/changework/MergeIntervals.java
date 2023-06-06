package com.changework;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {

        List<int []> res = new ArrayList<>();
        if(intervals == null || intervals.length ==0) return res.toArray(new int[0][]);
        /*按首位置进行排序*/
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
        Arrays.sort(intervals[0]);
        res.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            Arrays.sort(intervals[i]);
            if(res.get(res.size()-1)[1]>=intervals[i][0]){
                res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1],intervals[i][1]);
            }else{
                res.add(intervals[i]);
            }
        }
        int [][] matrix=res.toArray(new int[res.size()][]);
        return matrix;
    }

    public static void main(String[] args) {

        // write your code here
        MergeIntervals mergeIntervals =  new MergeIntervals();
        int[][] nums1 = new int[][]{{1,4},{4,5}};
//        int[][] nums1 = new int[][]{{6,2},{1,3},{8,10},{15,18}};
        int[][] matrix = mergeIntervals.merge(nums1);
        for(int j=0;j<matrix.length;j++){
            System.out.println ( Arrays.toString (matrix[j]));
        }
    }
}
