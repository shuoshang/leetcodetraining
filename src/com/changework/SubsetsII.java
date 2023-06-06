package com.changework;

import java.util.*;

//子集
public class SubsetsII {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(new LinkedList<>(),0,nums);
        LinkedHashSet<List<Integer>> hashSet = new LinkedHashSet<>(res);
        ArrayList<List<Integer>> listWithoutDuplicates = new ArrayList<>(hashSet);
        return listWithoutDuplicates;
    }

    public void dfs(LinkedList<Integer> remain,int first,int[] nums){
        if(first>nums.length){  //判断终止条件
            remain.removeLast();
            res.add(new LinkedList<Integer>(remain));  //添加到结果中
            remain.add(0);
            return;
        }
        for(int i=first;i<=nums.length;i++){
            if(i!=nums.length){
                remain.add(nums[i]);
            }else{
                remain.add(0);
            }
            dfs(remain,i+1,nums);
            remain.remove(remain.size()-1);
        }
    }

    public static void main(String[] args){
        // write your code here
        SubsetsII subsetsII =  new SubsetsII();
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> palindromepartitioning = subsetsII.subsetsWithDup(nums);
        System.out.println(palindromepartitioning.toString());
    }
}
