package com.changework;

import java.util.HashMap;

public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        int count = 0;
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                if(!map.containsKey(A[i]+B[j])){
                    map.put(A[i]+B[j],1);
                }else{
                    map.put(A[i]+B[j],map.get(A[i]+B[j])+1);
                }
            }
        }
        for(int i=0;i<C.length;i++){
            for(int j=0;j<D.length;j++){
                if(!map.containsKey(-(C[i]+D[j]))){
                    continue;
                }else{
                    count += map.get(-(C[i]+D[j]));
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        // write your code here
        FourSumII fourSumII =  new FourSumII();
        int[] A = new int[]{2,1};
        int[] B = new int[]{-2,-1};
        int[] C = new int[]{-1,2};
        int[] D = new int[]{0,2};
        int token = fourSumII.fourSumCount(A,B,C,D);
        System.out.println(token);
    }
}
