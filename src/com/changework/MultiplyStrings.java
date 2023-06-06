package com.changework;

public class MultiplyStrings {

    public String multiply(String num1, String num2) {

        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        StringBuilder str =  new StringBuilder();
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m+n];
        for(int i = m-1;i >= 0;i--){
            for(int j = n-1;j>=0;j-- ){
                int mul =( num1.charAt(i)-'0') * ( num2.charAt(j)-'0');
                int p1 = i+j,p2=i+j+1;
                //这次的p2是上一次的p1
                int sum = mul + res[p2];
                res[p2] = sum%10;
                res[p1] = res[p1]+sum /10;
            }
        }
        int k=0;
        while(k<res.length && res[k]==0){
            k++;
        }
        for(;k<res.length;k++){
            str.append(res[k]+"");
        }
        return res.length == 0 ? "0":str.toString();
    }

    public static void main(String[] args) {

        // write your code here
        MultiplyStrings multiplyStrings =  new MultiplyStrings();
        String t = multiplyStrings.multiply("143","144");
        System.out.println(t);
    }
}
