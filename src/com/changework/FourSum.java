package com.changework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < len-3; ++i){
            if(i > 0 && nums[i-1] == nums[i]){
                continue;
            }
            for(int j = i+1; j < len-2; ++j){
                int l = j + 1, r = len - 1;
                if(j > i + 1 && nums[j] == nums[j-1]){
                    continue;
                }
                while(l < r){
                    if(nums[i] + nums[j] + nums[l] + nums[r] == target){
                        if(l == j+1 || r == len-1){
                            List<Integer> list = new ArrayList<>();
                            list = Arrays.asList(nums[i], nums[j], nums[l], nums[r]);
                            res.add(list);
                            --r; ++l;
                        }else if(nums[l] == nums[l-1] || nums[r] == nums[r+1]){
                            --r; ++l;
                            continue;
                        }else{
                            List<Integer> list = new ArrayList<>();
                            list = Arrays.asList(nums[i], nums[j], nums[l], nums[r]);
                            res.add(list);
                            --r; ++l;
                        }
                    }else if(nums[i] + nums[j] + nums[l] + nums[r] > target){
                        --r;
                    }else{
                        ++l;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        // write your code here
        FourSum fourSum =  new FourSum();
        int[] A = new int[]{1, 0, -1, 0, -2, 2};
        List<List<Integer>> token = fourSum.fourSum(A,0);
        System.out.println(token.toString());
    }

}
