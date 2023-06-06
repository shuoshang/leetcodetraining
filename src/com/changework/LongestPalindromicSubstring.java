package com.changework;

import java.util.HashMap;
import java.util.Map;


//最长回文子串
//两层循环
//判断是否回文为公共方法（while）
//因为是找最长的，则需要max

public class LongestPalindromicSubstring {


    public String longestPalindrome(String s) {

        String longest = "";
        int ans = 0;
        if(isPalindroom( s,0,s.length()-1)) return s;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindroom(s,i,j) && (j - i + 1 > ans)) {
                    ans = Math.max(j - i + 1, ans);
                    longest = s.substring(i, j+1);
                }
            }
        }
        return longest;

    }

    public boolean isPalindroom(String s,int left,int i){
        while(left<i&&s.charAt(left)==s.charAt(i)){
            left++;
            i--;
        }
        return left>=i;
    }

        public static void main(String[] args) {

        // write your code here
        LongestPalindromicSubstring longestPalindromicSubstring =  new LongestPalindromicSubstring();
        String longestpalindromicsubstring = longestPalindromicSubstring.longestPalindrome("kztakrekvefgchersuoiuatzlmwynzjhdqqftjcqmntoyckqfawikkdrnfgbwtdpbkymvwoumurjdzygyzsbmwzpcxcdmmpwzmeibligwiiqbecxwyxigikoewwrczkanwwqukszsbjukzumzladrvjefpegyicsgctdvldetuegxwihdtitqrdmygdrsweahfrepdcudvyvrggbkthztxwicyzazjyeztytwiyybqdsczozvtegodacdokczfmwqfmyuixbeeqluqcqwxpyrkpfcdosttzooykpvdykfxulttvvwnzftndvhsvpgrgdzsvfxdtzztdiswgwxzvbpsjlizlfrlgvlnwbjwbujafjaedivvgnbgwcdbzbdbprqrflfhahsvlcekeyqueyxjfetkxpapbeejoxwxlgepmxzowldsmqllpzeymakcshfzkvyykwljeltutdmrhxcbzizihzinywggzjctzasvefcxmhnusdvlderconvaisaetcdldeveeemhugipfzbhrwidcjpfrumshbdofchpgcsbkvaexfmenpsuodatxjavoszcitjewflejjmsuvyuyrkumednsfkbgvbqxfphfqeqozcnabmtedffvzwbgbzbfydiyaevoqtfmzxaujdydtjftapkpdhnbmrylcibzuqqynvnsihmyxdcrfftkuoymzoxpnashaderlosnkxbhamkkxfhwjsyehkmblhppbyspmcwuoguptliashefdklokjpggfiixozsrlwmeksmzdcvipgkwxwynzsvxnqtchgwwadqybkguscfyrbyxudzrxacoplmcqcsmkraimfwbauvytkxdnglwfuvehpxd");
        System.out.println(longestpalindromicsubstring);
    }
}
