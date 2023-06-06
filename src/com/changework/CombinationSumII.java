package com.changework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

//用减法
public class CombinationSumII {


    List<List<Integer>> lists =  new ArrayList<>();
    List<List<Integer>> lists2 =  new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {



        if(candidates == null || candidates.length == 0  || target < 0 ){
            return lists;
        }

        Arrays.sort(candidates);
        List<Integer> list =  new ArrayList<>();
        List<Integer> list2 =  new ArrayList<>();

        process(0, candidates, target, list,list2);
        //hashset可以把list去重
        LinkedHashSet<List<Integer>> hashSet = new LinkedHashSet<>(lists);
        ArrayList<List<Integer>> listWithoutDuplicates = new ArrayList<>(hashSet);
        System.out.println(list2.toString());
        return lists;
    }

    public void process(int start,int[] candidates,int target, List<Integer> list,List<Integer> list2 ){
        if(target<0){
            return;
        }
        if(target == 0) {
            lists.add(new ArrayList<>(list));
        }else{
                for (int i = start; i < candidates.length; i++) {
                    list.add(candidates[i]);
                    //因为每个数字都可以使用无数次，所以递归还可以从当前元素开始
                    process(i+1, candidates, target - candidates[i], list,list2);
                    list.remove(list.size() - 1);
                }
        }
    }

    public static void main(String[] args) {

        // write your code here
        CombinationSumII combinationSumII =  new CombinationSumII();
        int[] nums = new int[]{10,1,2,7,6,1,5};
        List<List<Integer>>  number = combinationSumII.combinationSum(nums,8);
        System.out.println(number.toString());
    }
}
