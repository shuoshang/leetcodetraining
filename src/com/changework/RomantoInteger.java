package com.changework;

import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {

    public int romanToInt(String s) {

        Map<String,Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);

        int sum = 0;

        for (int i=0;i<s.length();i++){
            if(i !=(s.length()-1)){
                if(map.get(s.substring(i,i+1) ) >= map.get(s.substring(i+1,i+2) )       ){

                    sum = sum + map.get(s.substring(i,i+1) );

                }else {
                    sum = sum + map.get(s.substring(i+1,i+2) )-  map.get(s.substring(i,i+1));
                    i=i+1;
                }
         }else{
                sum = sum + map.get(s.substring(i,i+1) );
            }
        }

      return sum;

    }




    public static void main(String[] args) {

        // write your code here
        RomantoInteger romantoInteger =  new RomantoInteger();
        int romantoint = romantoInteger.romanToInt("MCMXCIV");
        System.out.println(romantoint);
    }
}
