package com.changework;

public class LongestSubstringWithAtLeastKRepeatingCharacters {

    public int longestSubstring(String s, int k) {
        int res = 0;
        int[] record =  new int[26];
        for(int i=0;i < s.length();i++){
            //每次循环都初始化数组
            setzeros(record);
            for(int t = i;t<s.length();t++){
                record[s.charAt(t)-'a']++;
                if(isexist(record,k)){
                    res = Math.max(res,t-i+1);
                }
            }
        }
        return res;
    }
    public void setzeros(int[] record){
        for(int j=0;j<record.length;j++){
            record[j] = 0;
        }
    }
    public boolean isexist(int[] record,int k){
        for(int j=0;j<record.length;j++){
            if(record[j]!=0 && record[j] < k){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        // write your code here
        LongestSubstringWithAtLeastKRepeatingCharacters longestSubstringWithAtLeastKRepeatingCharacters =  new LongestSubstringWithAtLeastKRepeatingCharacters();
        int longestsubstringint = longestSubstringWithAtLeastKRepeatingCharacters.longestSubstring("aabbaaa",3);
        System.out.println(longestsubstringint);
    }
}
