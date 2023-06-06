package com.changework;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
//找出最长的包含有效括号的子串的长度
//对于这道题目，因为我们要求的是子串的长度，因此我们可以考虑在栈中保存 index，
// 这样子我们不仅可以通过 index 找到对应的括号，还可以借此来求长度，我们的思路可以分为下面几步：
//1、从左到右遍历输入的字符串
//2、如果遇到的是 '('，意味着这并不能和前面遍历过的部分组成合法答案，此时我们只需要把当前 index 入栈即可
//3、如果遇到的是 ')'，这时我们就要看栈顶保存的元素了，这里就会有几种情况：
//栈顶保存的是 '('，表示当前元素和栈顶元素可以配对，这个时候我们需要把栈顶元素弹出栈，
// 记录答案则记录当前 index 和弹出配对元素后的新栈顶 index 之间的距离，这个地方是重点，如果不理解，你可以思考下面两个例子：
//"((()()"
//"((())"
//栈顶保存的是 ')'，如果是这种情况，表示前面没有可配对的  '('，我们此时还是需要把当前 index 入栈，原因是
//我们确定距离需要知道边界，如果不理解，还是有两个例子供你参考：
//"))(())"
//"())()()"
//栈是空的，当然在第一种情况中，你弹出栈顶元素后也会使得栈变空，为了避免这种情况，
// 我们可以在最开始的时候推一个 -1 入栈，这样可以节省我们的判断次数，并且当栈中的没有元素的时候，
// 我们也可以用这个 -1 来计算当前子串的长度，你可以参考下面这两个例子：
//"()"
//"()(())"
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;
        //-1入栈
        stack.push(-1);
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c == '(') {
               stack.push(i);
            }else{
                if(stack.peek() !=-1 && s.substring(stack.peek(),stack.peek()+1).contains("(")){
                    stack.pop();
                    res=Math.max(res,i-stack.peek());
                }else{
                    if(i==s.length()-1){
                        return res;
                    }else{
                        stack.push(i);
                    }
                }
            }
        }
        return res;

}

    public static void main(String[] args) {

        // write your code here
        LongestValidParentheses longestValidParentheses =  new LongestValidParentheses();
        int longestvalidparentheses = longestValidParentheses.longestValidParentheses("))(())");
        System.out.println(longestvalidparentheses);
    }

}
