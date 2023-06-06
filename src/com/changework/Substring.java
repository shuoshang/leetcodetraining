package com.changework;

import java.util.*;
public class Substring {
    public int substring (String s,String target){
        HashMap<String,Integer> map = new HashMap();
        for(int i=0;i<s.length()-target.length();i++){
            int count = 0;
            int k = i;
            for(int j =0;j<target.length();j++) {
                if (s.charAt(k) == target.charAt(j)) {
                    count++;
                }
                k++;
            }
            if(count==target.length()){
                if(!map.containsKey(target)){
                    map.put(target,i);
                }else{
                    map.put(target,-1);
                }
            }
        }
        return map.get(target);
    }



    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        Substring s = new Substring();

        System.out.println(s.substring("xxyyyzzzzz","yy"));

        System.out.println('b'-'a');
    }
}