package com.changework;
//1. 1
//2. 11
//3. 21
//4. 1211
//5. 111221
public class CountandSay {
    public String countAndSay(int n) {
        String str = "1";
        for(int i=2 ; i<=n; i++){
            StringBuilder builder = new StringBuilder();
            char pre = str.charAt(0);
            int count = 1;
            for(int j = 1;j < str.length();j++){
                char c = str.charAt(j);
                if( c== pre){
                    count++;
                }else{
                    builder.append(count).append(pre);
                    pre = c;
                    count = 1;
                }
            }
            builder.append(count).append(pre);
            str = builder.toString();

        }
        return str;

    }

    public static void main(String[] args) {

        // write your code here
        CountandSay countandSay =  new CountandSay();
        System.out.println(countandSay.countAndSay(5));
    }
}
