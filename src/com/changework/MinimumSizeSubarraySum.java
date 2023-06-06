package com.changework;

//定义两个指针 left 和 right ，分别记录子数组的左右的边界位置。
//（1）让 right 向右移，直到子数组和大于等于给定值或者 right 达到数组末尾；
//（2）更新最短距离，将 left 像右移一位,sum 减去移去的值；
//（3）重复（1）（2）步骤，直到 right 到达末尾，且 left 到达临界位置
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
//        int left = 0;
//        int res =  0 ;
//        while(  left < nums.length){
//            int zu = 0;
//            for(int right = left;right < nums.length;right++){
//                zu = zu + nums[right];
//                if(zu >= s ){
//                    if(res !=0){
//                        res = Math.min(res,right-left+1);
//                    }else{
//                        res = right-left+1;
//                    }
//                    break;
//                }else{
//                    continue;
//                }
//            }
//            left ++;
//        }
//        return res;
        int left =0;
        int right = -1;
        int sum =0;
        int res = nums.length + 1;
        while(left < nums.length){
            if(right + 1<nums.length && sum < s){
                right ++;
                sum +=nums[right];
            }else{
                sum -=nums[left];
                left++;
            }
            if(sum >= s){
                res = Math.min(res,right-left+1);
            }
        }
        if(res == nums.length + 1){
            return 0;
        }
        return res;

    }
    public static void main(String[] args) {

        // write your code here
        MinimumSizeSubarraySum minimumSizeSubarraySum =  new MinimumSizeSubarraySum();
        int[] tokens = new int[]{2,16,14,15};
        int token = minimumSizeSubarraySum.minSubArrayLen(20,tokens);
        System.out.println(token);
    }
}
