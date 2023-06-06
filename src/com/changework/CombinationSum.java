package com.changework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CombinationSum {

//    List<List<Integer>> lists =  new ArrayList<>();
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//
//        if(candidates == null || candidates.length == 0  || target < 0 ){
//            return lists;
//        }
//        List<Integer> list =  new ArrayList<>();
//        process(0, candidates, target, list);
//        return lists;
//    }
//
//    public void process(int start,int[] candidates,int target, List<Integer> list ){
//        if(target<0){
//            return;
//        }
//        if(target == 0) {
//            lists.add(new ArrayList<>(list));
//        }else{
//                for (int i = start; i < candidates.length; i++) {
//                    list.add(candidates[i]);
//                    //因为每个数字都可以使用无数次，所以递归还可以从当前元素开始
//                    process(i, candidates, target - candidates[i], list);
//                    list.remove(list.size() - 1);
//                }
//        }
//    }
public List<List<Integer>> combinationSum(int[] candidates, int target) {
    int len = candidates.length;
    List<List<Integer>> res = new ArrayList<>();
    if (len == 0) {
        return res;
    }

    Deque<Integer> path = new ArrayDeque<>();
    dfs(candidates, 0, len, target, path, res);
    return res;
}

    /**
     * @param candidates 候选数组
     * @param begin      搜索起点
     * @param len        冗余变量，是 candidates 里的属性，可以不传
     * @param target     每减去一个元素，目标值变小
     * @param path       从根结点到叶子结点的路径，是一个栈
     * @param res        结果集列表
     */
    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        // target 为负数和 0 的时候不再产生新的孩子结点
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 重点理解这里从 begin 开始搜索的语意
        for (int i = begin; i < len; i++) {
            path.addLast(candidates[i]);

            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs(candidates, i, len, target - candidates[i], path, res);

            // 状态重置
            path.removeLast();
        }
    }

    public static void main(String[] args) {

        // write your code here
        CombinationSum combinationSum =  new CombinationSum();
        int[] nums = new int[]{2,3,6,7};
        List<List<Integer>>  number = combinationSum.combinationSum(nums,7);
        System.out.println(number.toString());
    }
}
