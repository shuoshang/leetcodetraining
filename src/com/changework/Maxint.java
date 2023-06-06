package com.changework;

import java.util.HashMap;

public class Maxint {

    public int maxint (int[] a){
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 1;
        for(int i = 0;i<a.length;i++){
            if(!map.containsKey(a[i])){
                map.put(a[i],1);
            }else{
                max = Math.max(max,map.get(a[i])+1);
                map.put(a[i],map.get(a[i])+1);
            }
        }
        for(Integer j :map.keySet()){
            if(map.get(j) == max){
                return j;
            }
        }
        return max;
    }
}
