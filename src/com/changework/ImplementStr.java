package com.changework;

import java.util.List;

public class ImplementStr {

    public int strStr(String haystack, String needle) {

        if (haystack.equals("") &&  needle.equals("")){
            return 0;
        }

        for(int i = 0;i+needle.length()<=haystack.length();i++){
            if(haystack.substring(i,i+needle.length()).equals(needle)){
                 return i;
            }else{
                continue;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        // write your code here
        ImplementStr implementStr = new ImplementStr();
        int implementstr = implementStr.strStr("hello","ll");
        System.out.println(implementstr);
    }
}
