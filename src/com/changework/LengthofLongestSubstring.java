package com.changework;

import java.util.*;



//无重复字符的最长子串
//记录上一次
//一层循环，利用map
//因为是找最长的，则需要max

public class LengthofLongestSubstring {
    public int lengthofLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        int ans = 0;
        for (int end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(start, map.get(s.charAt(end)));
            }
            if (end - start + 1 > ans) {
                System.out.println(s.substring(start, end + 1));
            }
            ans = Math.max(end - start + 1, ans);
            map.put(s.charAt(end), end + 1);
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        LengthofLongestSubstring l = new LengthofLongestSubstring();
        int longestsubstringint = l.lengthofLongestSubstring("pwkewac");

        System.out.println(longestsubstringint);
    }
}