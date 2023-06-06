package com.changework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {

        int ans = 0;
        for(int i=0;i < s.length();i++){

            int num = s.charAt(i)-'A'+1;
            ans = ans * 26 + num;
        }
        return ans;
    }


    public static void main(String[] args) {

        // write your code here
        ExcelSheetColumnNumber excelSheetColumnNumber =  new ExcelSheetColumnNumber();
        int token = excelSheetColumnNumber.titleToNumber("ZY");
        System.out.println(token);
    }
}
