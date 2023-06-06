package com.changework;

import java.util.Stack;

public class DealString {
    public String numDecodings(String s){
        StringBuilder ss =  new StringBuilder();
        int i =0;
        if((int) s.charAt(0)==32){
            while((int) s.charAt(i)==32){
                i++;
            }
        }
        int count = 0;
        if(s.charAt(0) == s.charAt(1)){
            int i1 = count++;
        }
        while(i < s.length() ) {
            if((int) s.charAt(i)==32 && (int) s.charAt(i+1)!=32){
                ss.append(s.charAt(i));
                i++;
            }if((int) s.charAt(i)==32 && (int) s.charAt(i+1)==32){
                while((int) s.charAt(i)==32){
                    i++;
                }
                ss.append(s.charAt(i-1));
            }else{
                ss.append(s.charAt(i));
                i++;
            }
        }
      return ss.toString();
    }
    public static void main(String[] args) {
        // write your code here
        DealString dealString =  new DealString();
        String  numssorted = dealString.numDecodings("a   b c");
        System.out.println(numssorted);
    }
}
