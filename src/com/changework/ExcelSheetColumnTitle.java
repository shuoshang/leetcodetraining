package com.changework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {

        List<String> list = Arrays.asList("#","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");
        HashMap<Integer,String> map = new HashMap<>();
        for(int i = 0;i<=26;i++){
            map.put(i,list.get(i));
        }

        StringBuilder s = new StringBuilder();

        while(n>0){
            if(n%26==0){
                s.append("Z");
                n = n/26 -1;
            }else{
                s.append(map.get(n%26));
                n = n/26;
            }
        }
        return s.reverse().toString();

    }


    public static void main(String[] args) {

        // write your code here
        ExcelSheetColumnTitle excelSheetColumnTitle =  new ExcelSheetColumnTitle();
        String token = excelSheetColumnTitle.convertToTitle(701);
        System.out.println(token);
    }
}
