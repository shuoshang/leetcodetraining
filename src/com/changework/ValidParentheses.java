package com.changework;

import java.util.*;

//这道题让我们验证输入的字符串是否为括号字符串，包括大括号，中括号和小括号。
//这里我们使用栈。
//遍历输入字符串
//如果当前字符为左半边括号时，则将其压入栈中
//如果遇到右半边括号时，分类讨论：
//1）如栈不为空且为对应的左半边括号，则取出栈顶元素，继续循环
//2）若此时栈为空，则直接返回false
//3）若不为对应的左半边括号，反之返回false
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for(int i=0;i<s.length();i++){
           char c = s.charAt(i);
           if(map.containsKey(c)) {
               stack.push(c);
           }else{
               if(!stack.isEmpty() && ( map.get(stack.peek())==c  )){
                   stack.pop();
               }else{
                   return false;
               }
           }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }

    }


    public static void main(String[] args) {

        // write your code here
        ValidParentheses validParentheses =  new ValidParentheses();
        boolean validparentheses = validParentheses.isValid("()[]{}");
        System.out.println(validparentheses);
    }

}
