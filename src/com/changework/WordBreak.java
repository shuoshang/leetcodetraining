package com.changework;

import java.util.*;

public class WordBreak {
    Map<String, Integer> map = new HashMap<String, Integer>();
    Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
    Stack<Integer> stack = new Stack<Integer>();

    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.size()==0){
            return false;
        }
        for(String temp :wordDict){
            map.put(temp,0);
        }

        stack.push(0);
        if(isEqualLength(s,0)!=s.length()){
            while(!stack.isEmpty() ){
                if(isEqualLength(s,stack.peek())!=s.length()){
                    int k  = stack.peek();
                    map2.put(k,k);
                    stack.pop();
                }else{
                    return true;
                }
            }
        }else{
            return true;
        }
        return false;
    }

    public int isEqualLength(String s,int t){
        int flag = t;
        for(int i=t;i<s.length();i++){
            if(map.containsKey(s.substring(flag, i+1))){
                int tmp =  map.get(s.substring(flag, i+1))+1;
                map.put(s.substring(flag, i+1),tmp);
                if(!map2.containsKey(i+1)){
                    flag = i+1;
                    stack.push(flag);
                }else{
                    continue;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {

        // write your code here"bb"
        //["a","b","bbb","bbbb"]
        WordBreak wordBreak =  new WordBreak();
        List<String> wordDict = new ArrayList<>();
//        wordDict = Arrays.asList("go","goal","goals","special");
//        boolean wordbreak = wordBreak.wordBreak("goalspecial",wordDict);
//        wordDict = Arrays.asList("aa","aaaa");
        wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        boolean wordbreak = wordBreak.wordBreak("catsandog",wordDict);

        System.out.println(wordbreak);
    }
}
