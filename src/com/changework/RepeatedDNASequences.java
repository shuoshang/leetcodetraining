package com.changework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        if(s==null){
            return list;
        }
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<s.length()-9;i++){
            if(!map.containsKey(s.substring(i,i+10))){
                map.put(s.substring(i,i+10),1);
            }else{
                int t = map.get(s.substring(i,i+10));
                map.put(s.substring(i,i+10),t+1);
            }

        }
        for (String key : map.keySet()) {
            int k = map.get(key);
            if(k >1){
                list.add(key);
            }
        }
        return list;

    }

    public static void main(String[] args) {

        // write your code here
        RepeatedDNASequences repeatedDNASequences =  new RepeatedDNASequences();
        List<String>  repeateddnasequences = repeatedDNASequences.findRepeatedDnaSequences("AAAAAAAAAAA");
        System.out.println(repeateddnasequences.toString());
    }
}
