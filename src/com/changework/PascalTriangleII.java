package com.changework;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {

    public List<Integer> getRow(int rowIndex) {

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        if(rowIndex==0){
            list2.add(1);
            return list2;
        }
        List<Integer> newlist =  new ArrayList<>();
        newlist.add(1);
        list.add(newlist);
        for(int i =1;i<rowIndex+1 ;i++){
            List<Integer> newlist2 =  new ArrayList<>();
            for(int j =0;j<=i ; j++){
                if(j==0 || j==i){
                    newlist2.add(1);
                }else{
                    newlist2.add(list.get(i-1).get(j)+list.get(i-1).get(j-1));
                }
            }
            list.add(newlist2);
        }
        return list.get(rowIndex);
    }

    public static void main(String[] args) {

        // write your code here
        PascalTriangleII pascalTriangleII =  new PascalTriangleII();
        List<Integer> gen = pascalTriangleII.getRow(3);
        System.out.println(gen);
    }
}
