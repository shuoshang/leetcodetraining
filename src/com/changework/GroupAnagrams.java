package com.changework;

import java.util.*;


//字母异位词分组
//相同的字母排序后就一样了
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(int i =0;i<strs.length;i++){
            char[] dest = strs[i].toCharArray();
            Arrays.sort(dest);
            String str = new String(dest);
            if(!map.containsKey(str)){
                List<String> list =  new ArrayList<>();
                list.add(strs[i]);
                map.put(str,list);
            }else{
                map.get(str).add(strs[i]);
            }
        }
        for (Map.Entry<String,List<String>> entry : map.entrySet()) {
            lists.add(entry.getValue());
        }
        return lists;
    }

    public static void main(String[] args) {

        // write your code here
        GroupAnagrams groupAnagrams =  new GroupAnagrams();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>>  number = groupAnagrams.groupAnagrams(strs);
        System.out.println(number.toString());
    }
}
