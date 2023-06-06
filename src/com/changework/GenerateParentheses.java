package com.changework;

import java.util.*;

//括号生成-第22题
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
//        dfs(res, "", n, n);
//        return res;
//    }
//
//    void dfs(List<String> res, String  str,int left,int right)
//    {
//        if(left == 0 && right == 0)             res.add(str);
//        if(left > 0)          dfs(res, str + "(", left - 1, right);
//        if(right > left)      dfs(res, str + ")", left, right - 1);
//    }

          if(n==0) return res;
          if(n==1) {
              res.add("()");
          }
          for(int i=2;i<n+1;i++){
              List<String> tmp = new ArrayList<>();
              for(int j=0;j<i;j++){
                  List<String> now_list1 = new ArrayList<>();
                  List<String> now_list2 = new ArrayList<>();

              }
          }
        return res;
    }

    public static void main(String[] args) {

        // write your code here
        GenerateParentheses generateParentheses = new GenerateParentheses();
        List<String> lettercombinationsofaphonenumber = generateParentheses.generateParenthesis(3);
        System.out.println(lettercombinationsofaphonenumber.toString());
    }
}
