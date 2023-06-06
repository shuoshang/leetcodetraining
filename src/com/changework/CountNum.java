package com.changework;

import java.util.HashMap;

public class CountNum {
    public HashMap<Character,Integer> countNum(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }else{
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }

        }
        return map;
    }
    public static void main(String[] args) {

        CountNum c = new CountNum();
        HashMap<Character,Integer> map = new HashMap<>();
        map = c.countNum("a b c c a b");
        for(Character key : map.keySet()){
            System.out.println(key+":"+map.get(key));
        }
    }
}