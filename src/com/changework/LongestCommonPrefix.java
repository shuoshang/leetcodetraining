package com.changework;

import java.util.*;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
//        Map<Integer, String> map = new HashMap<>();
//        Map<String, Integer> map2 = new HashMap<>();
//
//        for (int i = 0; i < strs.length; i++) {
//            map.put(strs[i].length(), strs[i]);
//            map2.put(strs[i], strs[i].length());
//        }
//        Set<Integer> set = map.keySet();
//        Object[] obj = set.toArray();
//        Arrays.sort(obj);
//        String rmkey ="";
//        if(obj.length != 0){
//            rmkey = map.get(obj[0]);
//            map2.remove(rmkey);
//            Set<String> set2 = map2.keySet();
//            int ans = 0;
//            String returnstring = "";
//            for (int i = 0; i < 1; i++) {
//                for (int j = i; j < rmkey.length(); j++) {
//                    int count = 0;
//                    for (String setstring : set2) {
//                        if (!setstring.substring(0,j-i+1).contains(rmkey.substring(i, j  + 1))) {
////                            System.out.println(setstring);
////                            System.out.println(rmkey.substring(i,j+1));
//                            break;
//                        } else {
//                            count += 1;
//                        }
//                    }
//
//                    if (count == set2.size() && (j - i + 1 > ans)) {
//                        ans = Math.max(j - i + 1, ans);
//                        returnstring = rmkey.substring(i, j  + 1);
////                        System.out.println(count);
//                    }
//                }
//            }
//            return returnstring;
//        }else{
//            return "";
//        }
        if (strs == null || strs.length == 0) return "";
        String res = strs[0];
        System.out.println(strs[1].indexOf(res));
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(res) != 0) {
                res = res.substring(0, res.length() - 1);
            }
            i += 1;
        }
        return res;
    }

    public static void main(String[] args) {

        // write your code here
        LongestCommonPrefix longestCommonPrefix =  new LongestCommonPrefix();
        String[] strs = new String[]{"flower","flow","flight"};
        String longestcommonprefix = longestCommonPrefix.longestCommonPrefix(strs);
        System.out.println(longestcommonprefix);
    }


}
