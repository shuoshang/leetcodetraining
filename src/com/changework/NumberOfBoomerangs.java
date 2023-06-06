package com.changework;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {

        int res = 0;
        for(int i = 0;i<points.length ; i++){
            Map<Integer,Integer> map =  new HashMap<>();
            for(int j=0;j<points.length;j++){
                if(j!=i){
                    if(!map.containsKey(longsub(points[i],points[j]))){
                        map.put(longsub(points[i],points[j]),1);
                    }else {
                        map.put(longsub(points[i],points[j]),map.get(longsub(points[i],points[j]))+1);
                    }
                }
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    res = res +  entry.getValue()* (entry.getValue()-1);

            }
        }
        return res;
    }
    public int longsub(int[] pa , int[] pb){
        return (pa[0]-pb[0])* (pa[0]-pb[0]) + (pa[1]-pb[1])* (pa[1]-pb[1]);
    }


    public static void main(String[] args) {

        // write your code here
        NumberOfBoomerangs numberOfBoomerangs =  new NumberOfBoomerangs();
        int[][] points = new int[][]{ {0,0},{1,0},{-1,0},{0,1},{0,-1}};
        int  baoshu = numberOfBoomerangs.numberOfBoomerangs(points);
        System.out.println(baoshu);
    }
}
