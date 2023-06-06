package com.changework;


import java.util.Arrays;
import java.util.Stack;

//1.此题主要考察的是栈,所以定义一个辅助栈;
//2.先把字符串以"/"为分隔符分割成数组,此时数组有"路径"、""、"."、".."这四种情况;
//3.遍历数组,当s[i].equals("..")并且栈不空时pop,当!s[i].equals("") && !s[i].equals(".") && !s[i].equals(".."),即s[i]是路径入栈;
//4.栈空,返回"/",栈非空,用StringBuffer做一个连接返回即可;
//5完结。
public class SimplifyPath {

    public String simplifyPath(String path) {

        String[] s = path.split("/");
        Stack stack = new Stack();
        System.out.println(Arrays.toString(s));
        for(int i=0;i<s.length;i++){
            if(s[i].equals("..") && !stack.isEmpty() ){
                stack.pop();
            }
            if(!s[i].equals("") && !s[i].equals(".") && !s[i].equals("..")){
                stack.push(s[i]);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        if(stack.isEmpty()){
            return "/";
        }else{
            while (!stack.isEmpty()){
                stringBuilder.insert(0,stack.peek());
                stringBuilder.insert(0,"/");
                stack.pop();
            }
        }
            return stringBuilder.toString();
    }

    public static void main(String[] args) {

        // write your code here
        SimplifyPath simplifyPath =  new SimplifyPath();
        String romantoint = simplifyPath.simplifyPath("/home//foo/");
        System.out.println(romantoint);
    }
}
