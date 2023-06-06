package com.changework;

import java.util.*;

//解码方法-第91题
public class DecodeWays {
    List<List<String>> res = new ArrayList<>();
    int count = 0;
    Map<String,String> map = new HashMap<>();
    public int numDecodings(String s) {
//        for(int t=1;t<=26;t++){
//            String st = String.valueOf(t);
//            map.put(st,"1");
//        }
//        if(s==null||s.length()==0 )
//            return 0;
//        dfs(s,new ArrayList<String>(),0);
//        System.out.println(res.toString());
//        System.out.println(count);
//        return res.size()-count > 0 ? res.size()-count : 0 ;

        int[] dp= new int[s.length()+1];
        dp[0]=1;    //ways to decode an empty string is 0
        dp[1]= s.charAt(0)=='0' ? 0:1;    //if first char is 0, there is no mapping for zero
        for(int i=2; i<dp.length; i++){
            int oneDigit= Integer.valueOf(s.substring(i-1, i));
            int twoDig= Integer.valueOf(s.substring(i-2, i));
            //All the ways if we take only the current character
            if(oneDigit>=1)
                dp[i]+= dp[i-1];
            //If we take prev 2 digits
            if(twoDig>=10 && twoDig<=26)
                dp[i]+=dp[i-2];
        }
        return dp[s.length()];
    }

    public void dfs(String s,List<String> remain,int left){
        if(left==s.length()){  //判断终止条件
            List addnew = new ArrayList<String>(remain);
            for(int k=0;k<addnew.size();k++){
                if(!map.containsKey(addnew.get(k))){
                    count = count+1;
                    break;
                }
            }
            res.add(new ArrayList<String>(remain));  //添加到结果中
            return;
        }
        for(int i=left;i<s.length();i++){  //从left开始，依次判断left->i是不是回文串

            remain.add(s.substring(left,i+1));   //添加到当前回文串到list中
            dfs(s,remain,i+1);  //从i+1开始继续递归，寻找回文串
            remain.remove(remain.size()-1);  //回溯，从而寻找更长的回文串

        }
    }

    public static void main(String[] args){
        // write your code here
        DecodeWays decodeWays =  new DecodeWays();
        int palindromepartitioning = decodeWays.numDecodings("111111111111111111111111111111111111111111111");
        System.out.println(palindromepartitioning);
    }
}
