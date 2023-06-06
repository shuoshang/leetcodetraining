package com.changework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//131-分割回文串
public class PalindromePartitioning {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if(s==null||s.length()==0)
            return res;
        dfs(s,new ArrayList<String>(),0);
        return res;
    }

    public void dfs(String s,List<String> remain,int left){
        if(left==s.length()){  //判断终止条件
            res.add(new ArrayList<String>(remain));  //添加到结果中
            return;
        }
        for(int i=left;i<s.length();i++){  //从left开始，依次判断left->i是不是回文串
            if(isPalindroom(s,left,i)){  //判断是否是回文串
                remain.add(s.substring(left,i+1));   //添加到当前回文串到list中
                dfs(s,remain,i+1);  //从i+1开始继续递归，寻找回文串
                //remain.remove(remain.size()-1);  //回溯，从而寻找更长的回文串
            }
        }
    }
    /**
     * 判断是否是回文串
     */
    public boolean isPalindroom(String s,int left,int i){
        while(left<i&&s.charAt(left)==s.charAt(i)){
            left++;
            i--;
        }
        return left>=i;
    }



    public static void main(String[] args){
        // write your code here
        PalindromePartitioning palindromePartitioning =  new PalindromePartitioning();
        List<List<String>> palindromepartitioning = palindromePartitioning.partition("aab");
        System.out.println(palindromepartitioning);
    }
}

