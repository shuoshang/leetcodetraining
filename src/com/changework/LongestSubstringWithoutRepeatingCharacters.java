package com.changework;

import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;

//无重复字符的最长子串
//建立一个256位大小的整型数组 freg ，用来建立字符和其出现位置之间的映射。
//维护一个滑动窗口，窗口内的都是没有重复的字符，去尽可能的扩大窗口的大小，窗口不停的向右滑动。
//（1）如果当前遍历到的字符从未出现过，那么直接扩大右边界；
//（2）如果当前遍历到的字符出现过，则缩小窗口（左边索引向右移动），然后继续观察当前遍历到的字符；
//（3）重复（1）（2），直到左边索引无法再移动；
//（4）维护一个结果res，每次用出现过的窗口大小来更新结果 res，最后返回 res 获取结果。


public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int start = 0;
        int ans = 0;
        for(int end = 0;end <s.length();end++){

            if(map.containsKey(s.charAt(end))){

                start = Math.max(start,map.get(s.charAt(end)));
            }
            //已知的长度和现有的长度比较
                ans =  Math.max(end-start +1,ans);
                map.put(s.charAt(end),end+1);

        }


        SimpleDateFormat sdfs = new SimpleDateFormat("yyyyMMdd");
        String reqDate = sdfs.format(System.currentTimeMillis()) ;
        System.out.println(reqDate);
        return ans;

    }


    public static void main(String[] args) {

        // write your code here
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters =  new LongestSubstringWithoutRepeatingCharacters();
        int longestsubstringint = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("pwwkew");
        System.out.println(longestsubstringint);
    }
}
