package com.changework;

import java.util.*;
//单词接龙
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String> reached = new ArrayList<>();
        reached.add(beginWord);
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;
        int distance = 1;
        while (!reached.contains(endWord)){ //到达该目的地

            List<String> toAdd = new ArrayList<>();
            for(String each : reached){
                for(int i = 0;i < each.length();i++){
                    char[] chars = each.toCharArray();
                    for(char c='a';c<='z';c++){
                        chars[i] = c;
                        String wd = new String(chars);
                        if(wordSet.contains(wd)){
                            toAdd.add(wd);
                            wordSet.remove(wd); //记录访问状态
                        }
                    }
                }
            }
            distance ++;
            if (toAdd.size() == 0) return 0; //没有编辑距离为1的单词
            reached = toAdd;
        }
        return distance;
    }
    public static void main(String[] args) {

        WordLadder wordLadder =  new WordLadder();
        List<String> wordDict = new ArrayList<>();
//        wordDict = Arrays.asList("go","goal","goals","special");
//        boolean wordbreak = wordBreak.wordBreak("goalspecial",wordDict);
        wordDict = Arrays.asList("hot","dot","dog","lot","log","cog");
        int wordbreak = wordLadder.ladderLength("hit","cog",wordDict);
        System.out.println(wordbreak);
    }
}
