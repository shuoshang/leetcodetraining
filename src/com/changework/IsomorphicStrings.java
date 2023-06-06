package com.changework;

import java.util.Arrays;
import java.util.HashMap;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {

        return isUniqueMap(s,t) && isUniqueMap(t,s);
    }

    public boolean isUniqueMap(String s , String t){
        HashMap<Character,Character> map =  new HashMap<>();
        for(int i =0;i<s.length();i++){
            Character c1 = s.charAt(i);
            Character c2 = t.charAt(i);
            if(!map.containsKey(c1)){
                map.put(c1,c2);
            }else{
                if(map.get(c1)!=c2){
                    return false;
                }else{
                    map.put(c1,c2);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        // write your code here
        IsomorphicStrings isomorphicStrings =  new IsomorphicStrings();
        String s = "paper";
        String t = "title";
        boolean intersectint = isomorphicStrings.isIsomorphic(s,t);
        System.out.println(intersectint);
    }

}
