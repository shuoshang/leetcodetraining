package com.changework;

import java.util.Arrays;
import java.util.Stack;

//从前往后遍历数组
//遇到数字则压入栈中
//遇到符号，则把栈顶的两个数字拿出来运算，把结果再压入栈中
//遍历完整个数组，栈顶数字即为最终答案
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {

        Stack<String> stack = new Stack<>();
        Stack<Integer> ints = new Stack<>();
        for(int i = 0;i<tokens.length;i++){
            String s = tokens[i];
            if(s.equals("+")  || s.equals("-" ) || s.equals( "*" )|| s.equals("/") ){
                    int num1 = ints.peek();
                    ints.pop();
                    int num2 = ints.peek();
                    ints.pop();
                    if(s.equals("+")){
                        ints.push(num1 + num2);
                    }else if(s.equals("-" )){
                        ints.push(num2 - num1);
                    }else if(s.equals( "*" )){
                        ints.push(num1 * num2);
                    }else {
                        ints.push(num2 / num1);
                    }
            }else{
                ints.push(Integer.parseInt(tokens[i]));
            }
        }
        return ints.peek();
     }

    public static void main(String[] args) {

        // write your code here
        EvaluateReversePolishNotation evaluateReversePolishNotation =  new EvaluateReversePolishNotation();
        String[] tokens = new String[]{"4","13","5","/","+"};
        int token = evaluateReversePolishNotation.evalRPN(tokens);
        System.out.println(token);
    }
}
