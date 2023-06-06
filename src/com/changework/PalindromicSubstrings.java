package com.changework;

import java.util.LinkedList;
import java.util.List;

public class PalindromicSubstrings {
    List<String> res = new LinkedList<>();

    public int countSubstrings(String s) {
        StringBuilder remain = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            remain.append(s.charAt(i));
            if(isPalindroom(remain.toString(),0,remain.toString().length()-1)){
                res.add(remain.toString());
            }
            for (int j = i+1; j < s.length(); j++) {
                remain.append(s.charAt(j));
                if(isPalindroom(remain.toString(),0,remain.toString().length()-1)){
                    res.add(remain.toString());
                }
            }
            remain.delete(0,remain.length());
        }
        System.out.println(res);
        return res.size();



//        dfs(new StringBuilder(),0,s);
//        System.out.println(res);
//        return res.size();
    }

    public void dfs(StringBuilder remain,int first,String s){
        if(remain.length()==s.length() || first-1>1){  //判断终止条件
            return;
        }
        for(int i=first;i<s.length();i++){
            //判断是否是回文串
            remain.append(s.charAt(i));

            if(isPalindroom(remain.toString(),0,remain.toString().length()-1)){
                res.add(remain.toString());
            }
            dfs(remain,i+1,s);
            remain.deleteCharAt(remain.toString().length()-1);
        }
    }

    public boolean isPalindroom(String s,int left,int i){
        while(left<i&&s.charAt(left)==s.charAt(i)){
            left++;
            i--;
        }
        return left>=i;
    }

    public static void main(String[] args){
        // write your code here
        PalindromicSubstrings palindromicSubstrings =  new PalindromicSubstrings();
        int palindromepartitioning = palindromicSubstrings.countSubstrings("aaa");
        System.out.println(palindromepartitioning);
    }
}
