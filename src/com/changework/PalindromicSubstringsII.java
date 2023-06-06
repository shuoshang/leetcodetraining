package com.changework;

import java.util.LinkedList;
import java.util.List;

public class PalindromicSubstringsII {
    List<String> res = new LinkedList<>();

    public int countSubstrings(String s) {
           int ret = 0;
           for(int i= 0 ;i<s.length();i++){
              dfs(new StringBuilder(),i,s);
              System.out.println(res);
           }

        return res.size();

    }

    public void dfs(StringBuilder remain,int first,String s){
        if(remain.length()==s.length()){  //判断终止条件
            return;
        }
            //判断是否是回文串
            if(first< s.length()){
                remain.append(s.charAt(first));
            }
            if(isPalindroom(remain.toString(),first,remain.toString().length())){
                res.add(remain.toString());
            }
            dfs(remain,first+1,s);
            remain.deleteCharAt(remain.toString().length()-1);
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
        int palindromepartitioning = palindromicSubstrings.countSubstrings("aaaaaaaaaaaa");
        System.out.println(palindromepartitioning);
    }
}
