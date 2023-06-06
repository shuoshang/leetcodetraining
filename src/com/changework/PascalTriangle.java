package com.changework;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> list = new ArrayList<>();
        if(numRows==0){
            return list;
        }
        List<Integer> newlist =  new ArrayList<>();
        newlist.add(1);
        list.add(newlist);
        for(int i =1;i<numRows ;i++){
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
        return list;
    }

    public static void main(String[] args) {

        // write your code here
        PascalTriangle pascalTriangle =  new PascalTriangle();
        List<List<Integer>> gen = pascalTriangle.generate(5);
        System.out.println(gen);
    }
}
