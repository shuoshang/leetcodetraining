package com.changework;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    ArrayList<String> result = new ArrayList<>();

    public ArrayList<String> restoreIpAddresses(String str) {
        restoreIpAddresses(str, 0, new ArrayList<String>());
        return result;
    }

    private void restoreIpAddresses(String str, int startIndex, List<String> paths) {
        // 当凑出有效的 IP 地址回溯，即 paths.size() == 4 回溯
        if (paths.size() == 4) {
            result.add(paths.get(0) + "." + paths.get(1) + "." + paths.get(2) + "." + paths.get(3));
            return;
        }

        // 每个 IP 地址段的长度可能为 1~3，所以我们需要搜索这三种可能性
        for (int i = startIndex; i < startIndex + 3 && i < str.length(); i++) {
            // 截取当前 IP 字符串
            String subStr = (paths.size() == 3) ? str.substring(startIndex, str.length()) : str.substring(startIndex, i + 1);
            // 解析当前 IP 地址值
            Integer subNum = Integer.parseInt(subStr);
            // 如果 IP 地址合法
            if (subNum >= 0 && subNum <= 255) {
                // 将当前合法的 IP 地址段添加至 paths 中
                paths.add(subNum.toString());
                // 递归搜索
                restoreIpAddresses(str, i + 1, paths);
                // 恢复现场
                paths.remove(paths.size() - 1);
            } else {
                // 当前的 IP 地址不符合要求时开始回溯(不在 0~255 范围之间)
                return;
            }
            if (paths.size() == 3) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution =  new Solution();
        ArrayList<String> result = new ArrayList<>();
        result = solution.restoreIpAddresses("2534235253");
        System.out.println(result);


    }
}
