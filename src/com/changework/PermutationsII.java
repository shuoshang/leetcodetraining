package com.changework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class PermutationsII {

    List<List<Integer>> lists =  new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0  ){
            return lists;
        }
        permutation(lists,nums,0);
        LinkedHashSet<List<Integer>> hashSet = new LinkedHashSet<>(lists);
        ArrayList<List<Integer>> listWithoutDuplicates = new ArrayList<>(hashSet);
        return listWithoutDuplicates;

    }
    public void permutation(List<List<Integer>> lists,int[] nums,int index) {
        if (index >= nums.length) {
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
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
        PermutationsII permutations =  new PermutationsII();
        int[] numss = new int[]{1,1,2};
        List<List<Integer>> palindromepartitioning = permutations.permuteUnique(numss);
        System.out.println(palindromepartitioning);
    }

}
