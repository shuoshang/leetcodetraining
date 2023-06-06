package com.changework;

//所以我们只要考虑当天买和之前买哪个收益更高，当天卖和之前卖哪个收益更高。

//buy = max(buy, -price[i]) （注意：根据定义 buy 是负数）
//sell = max(sell, prices[i] + buy)
//边界
//第一天 buy = -prices[0], sell = 0，最后返回 sell 即可。
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {

//        int buy = 0;
//        int sell = 0;
//
//        if(prices.length==0){
//            return 0;
//        }else{
//            for(int i=0;i<prices.length;i++){
//                if(i==0){
//                    buy = -prices[0];
//                    sell = 0;
//                }else{
//                    buy = Math.max(buy, -prices[i]);
//                    sell = Math.max(sell, prices[i] + buy);
//                }
//            }
//            return sell;
//        }

        int buy = 0;
        int sell = 0;

        if(prices.length==0){
            return 0;
        }else{
            for(int i=0;i<prices.length;i++){
                if(i==0){
                    buy = -prices[0];
                    sell = 0;
                }else{
                    buy = Math.max(buy, sell-prices[i]);
                    sell = Math.max(sell, prices[i] + buy);
                }
            }
            return sell;
        }

    }


    public static void main(String[] args) {

        // write your code here
        BestTimetoBuyandSellStock bestTimetoBuyandSellStock =  new BestTimetoBuyandSellStock();
        int[] nums = new int[]{7,6,4,3,1};
        int sell = bestTimetoBuyandSellStock.maxProfit(nums);
        System.out.println(sell);
    }
}
