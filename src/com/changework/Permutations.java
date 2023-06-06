package com.changework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


//全排列
//index和i没关系

public class Permutations {
    List<List<Integer>> lists =  new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0  ){
            return lists;
        }
        permutation(lists,nums,0);
        return lists;
    }

    public void permutation(List<List<Integer>> lists,int[] nums,int index) {
        if (index >= nums.length) {
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            System.out.println(list.toString());
            lists.add(list);
            return;
        }
         for (int i = index; i < nums.length; i++) {
            swap(i,index,nums);
            permutation(lists, nums, index + 1);
            swap(index,i,nums);
        }
    }

    public void swap(int i ,int index,int[] nums) {
        int k = nums[i];
        nums[i] = nums[index];
        nums[index] = k;
    }

    public static void main(String[] args){
        // write your code here
        Permutations permutations =  new Permutations();
        int[] numss = new int[]{1,2,3};
        List<List<Integer>> palindromepartitioning = permutations.permute(numss);
//        System.out.println(palindromepartitioning);
    }
}
