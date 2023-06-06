package com.changework;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int[] table =  new int[26];
        for(int i=0;i<s.length();i++){
            table[s.charAt(i)-'a']++;
        }
        for(int j=0;j<t.length();j++){
            table[t.charAt(j)-'a']--;
            if(table[t.charAt(j)-'a']<0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        // write your code here
        ValidAnagram validAnagram =  new ValidAnagram();
        String s = "anagram";
        String t = "nagaram";
        boolean validanagram = validAnagram.isAnagram(s,t);
        System.out.println(validanagram);
    }
}
