package com.changework;
//状态
//有 第一次买入（fstBuy） 、 第一次卖出（fstSell）、第二次买入（secBuy） 和 第二次卖出（secSell） 这四种状态。
//
//转移方程
//这里最多两次买入和两次卖出，也就是说 买入 状态之前可拥有 卖出 状态，卖出 状态之前可拥有 买入 状态，所以买入和卖出的转移方程都需要变化。
//
//fstBuy = max(fstBuy ， -price[i])
//fstSell = max(fstSell，fstBuy + prices[i] )
//secBuy = max(secBuy ，fstSell -price[i]) (受第一次卖出状态的影响)
//secSell = max(secSell ，secBuy + prices[i] )
//边界
//一开始 fstBuy = -prices[0]
//
//买入后直接卖出，fstSell = 0
//
//买入后再卖出再买入，secBuy - prices[0]
//
//买入后再卖出再买入再卖出，secSell = 0
//
//最后返回 secSell 。
public class BestTimetoBuyandSellStockIII {


    public int maxProfit(int[] prices) {



        if (prices.length == 0) {
            return 0;
        } else {
            int fstBuy = -prices[0];
            int fstSell = 0;
            int secBuy =  -prices[0];
            int secSell = 0;
            for (int i = 0; i < prices.length; i++) {

                fstBuy = Math.max(fstBuy,  -prices[i]);
                fstSell = Math.max(fstSell, prices[i] + fstBuy);
                secBuy = Math.max(secBuy,fstSell -prices[i]);
                secSell = Math.max(secSell,secBuy + prices[i] );
            }
            return secSell;
        }

    }


    public static void main(String[] args) {

        // write your code here
        BestTimetoBuyandSellStock bestTimetoBuyandSellStock = new BestTimetoBuyandSellStock();
        int[] nums = new int[]{3,3,5,0,0,3,1,4};
        int sell = bestTimetoBuyandSellStock.maxProfit(nums);
        System.out.println(sell);
    }
}