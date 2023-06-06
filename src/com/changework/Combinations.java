package com.changework;

import java.util.LinkedList;
import java.util.List;

public class Combinations {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(new LinkedList<>(),1,k,n);
         return res;
    }

    public void dfs(LinkedList<Integer> remain,int first,int k,int n){
        if(remain.size()==k){  //判断终止条件
            res.add(new LinkedList<Integer>(remain));  //添加到结果中
            return;
        }
        for(int i=first;i<n+1;i++){
              //判断是否是回文串
                remain.add(i);
                dfs(remain,i+1,k,n);
                remain.remove(remain.size()-1);
            }
    }

    public static void main(String[] args){
        // write your code here
        Combinations combinations =  new Combinations();
        List<List<Integer>> palindromepartitioning = combinations.combine(4,2);
        System.out.println(palindromepartitioning.toString());
    }
}
