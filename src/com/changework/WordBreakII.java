package com.changework;

import java.util.*;

public class WordBreakII {


        Set<String> memory = new HashSet<>();
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>();
            for(String str : wordDict){
                set.add(str);
            }
            return DFS(s,set);
        }
        public boolean DFS(String s,Set<String> set){
            if(s.length()==0) return true;
            if(memory.contains(s)) return false;//如果记忆中存在此字符串，返回false，结束递归。
            StringBuilder strb = new StringBuilder();
            for(int i=0;i<s.length();i++){
                strb.append(s.charAt(i));
                if(set.contains(strb.toString()) && !memory.contains(s.substring(i+1))){
                    if(DFS(s.substring(i+1),set)){
                        return true;
                    }else{
                        memory.add(s.substring(i+1));//对子串失败的情况进行记忆
                    }
                }
            }
            memory.add(s);//对s失败的情况进行记忆
            return false;
        }
    public static void main(String[] args) {

        // write your code here"bb"
        //["a","b","bbb","bbbb"]
        WordBreakII wordBreak =  new WordBreakII();
        List<String> wordDict = new ArrayList<>();
//        wordDict = Arrays.asList("go","goal","goals","special");
//        boolean wordbreak = wordBreak.wordBreak("goalspecial",wordDict);
        wordDict = Arrays.asList("apple","pen");
        boolean wordbreak = wordBreak.wordBreak("applepenapple",wordDict);

        System.out.println(wordbreak);
    }

}
