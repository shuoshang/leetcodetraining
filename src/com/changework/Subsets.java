package com.changework;

import java.util.LinkedList;
import java.util.List;

//子集
//first=0.dfs(r,0)
//第一层分支 first=0,i=0    first=0,i=1     first=0,i=2
//           dfs(r,1)       dfs(r,2)        dfs(r,3)
//注意：返回之后，回溯一次；i到头之后回溯一次；走完一条线就不走了
//超过子集个数了，就要回溯了
//因为回溯两次才能回到[1,2]，所以需要加个数
public class Subsets {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(new LinkedList<>(),0,nums);
        return res;
    }

    public void dfs(LinkedList<Integer> remain,int first,int[] nums){
        if(first>nums.length){  //判断终止条件
                remain.removeLast();
                res.add(new LinkedList<Integer>(remain));  //添加到结果中
                remain.add(0);
                return;
        }
        for(int i= first;i<=nums.length;i++){
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
        Subsets subsets =  new Subsets();
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> palindromepartitioning = subsets.subsets(nums);
        System.out.println(palindromepartitioning.toString());
    }
}
