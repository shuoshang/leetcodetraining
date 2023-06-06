package com.changework;


//p[j] 是字母，并且 s[i] == p[j]，当前子问题成立与否取决于子问题 s[0…i-1] 和 p[0…j-1] 是否成立
//p[j] 是 '.'，当前子问题成立与否取决于子问题 s[0…i-1] 和 p[0…j-1] 是否成立
//p[j] 是字母，并且 s[i] != p[j]，当前子问题不成立
//p[j] 是 '*'，s[i] == p[j - 1]，或者 p[j - 1] == '.'， 当前子问题成立与否取决于子问题 s[0…i-1] 和 p[0…j] 是否成立
//p[j] 是 '*'，s[i] != p[j - 1]，当前子问题正确与否取决于子问题 s[0…i] 是否匹配 p[0,…j-2]
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {

        boolean[][] flag = new boolean[s.length()][p.length()];

        int i = 0;
        int j = 0;
        while(i<s.length() || j < p.length()){
            if(Character.isLetter(p.charAt(j)) || p.charAt(j)=='.') {

                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {

                    if (i == 0 || j == 0) {
                        flag[i][j] = true;
                        i++;
                        j++;
                    } else {
                        if (flag[i - 1][j - 1]) {
                            flag[i][j] = true;
                            i++;
                            j++;
                        } else {
                            j++;
                            continue;
                        }

                    }
                }else{
                    j++;
                    continue;
                }
            }

             else{

                if(j==0){
                    flag[i][j]=true;
                    i++;
                    j++;
                }else{
                    if(s.charAt(i)==p.charAt(j-1) || p.charAt(j-1)=='.'){
                        if(i==0){
                            flag[i][j]=true;
                            i++;
                            j++;
                        }else{
                            if(flag[i-1][j]){
                                flag[i][j]=true;
                                i++;
                                j++;
                            }else{
                                j++;
                                continue;
                            }
                        }
                    }else{
                        if(j>=2){
                            if(flag[i][j-2]){
                                flag[i][j]=true;
                                i++;
                                j++;
                            }else{
                                j++;
                                continue;
                            }
                        }else{
                            j++;
                            continue;
                        }
                    }

                }

            }


            }
        return flag[s.length()-1][p.length()-1];

    }

    public static void main(String[] args) {

        // write your code here
        RegularExpressionMatching regularExpressionMatching =  new RegularExpressionMatching();
        boolean n = regularExpressionMatching.isMatch("aab","c*a*b");
        System.out.println(n);
    }
}
