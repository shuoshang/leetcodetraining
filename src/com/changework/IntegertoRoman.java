package com.changework;

import java.util.HashMap;
import java.util.Map;

public class IntegertoRoman {

    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i =3;i>=0;i--){
            int m = (int)Math.pow(10,i);
            int zh = num / m;
            if(zh == 0){
                continue;
            }else{
                num = num % m;
                if(m==1000) {
                    for(int j=1;j<=zh;j++){
                        stringBuilder.append("M");
                    }
                }else if(m==100){
                    if(zh>=1 && zh<4){
                        for(int j=1;j<=zh;j++){
                            stringBuilder.append("C");
                        }
                    }else if(zh == 4){
                        stringBuilder.append("CD");
                    }else if(zh >= 5 && zh< 9){
                        stringBuilder.append("D");
                        int k = (zh*m - 500)/100;
                        if(k>=1){
                            for(int j=1;j<=k;j++){
                                stringBuilder.append("C");
                            }
                        }
                    }else{
                        stringBuilder.append("CM");
                    }
                }else if(m==10){
                    if(zh>=1 && zh<4){
                        for(int j=1;j<=zh;j++){
                            stringBuilder.append("X");
                        }
                    }else if(zh == 4){
                        stringBuilder.append("XL");
                    }else if(zh >= 5 && zh< 9){
                        stringBuilder.append("L");
                        int k = (zh*m - 50)/10;
                        if(k>=1){
                            for(int j=1;j<=k;j++){
                                stringBuilder.append("X");
                            }
                        }
                    }else{
                        stringBuilder.append("XC");
                    }
                }else{
                    if(zh>=1 && zh<4){
                        for(int j=1;j<=zh;j++){
                            stringBuilder.append("I");
                        }
                    }else if(zh == 4){
                        stringBuilder.append("IV");
                    }else if(zh >= 5 && zh< 9){
                        stringBuilder.append("V");
                        int k = zh - 5;
                        if(k>=1){
                            for(int j=1;j<=k;j++){
                                stringBuilder.append("I");
                            }
                        }
                    }else{
                        stringBuilder.append("IX");
                    }
                }
            }
        }
        return stringBuilder.toString();
    }



    public static void main(String[] args) {

        // write your code here
        IntegertoRoman integertoRoman =  new IntegertoRoman();
        String romantoint = integertoRoman.intToRoman(60);
        System.out.println(romantoint);
    }
}
