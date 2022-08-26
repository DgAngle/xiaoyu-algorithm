package com.study.dynamicPlan;

/**
 * 最大利润
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 设计一个算法来计算你所能获取的最大利润。你最多可以完成 2笔交易（买一次再卖一次）
 *
 * @author gqshuang
 * @version 1.0
 * @date 2022/5/16 18:38
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        // System.out.println(getMaxProfit(prices, 2));
        System.out.println(maxProfitIII(prices, 2));
    }

    /**
     * 获取最大利润
     *
     * @param prices 需要解析的数组
     * @param times  交易次数
     * @return 最大利润
     */
    public static int getMaxProfit(int[] prices, int times) {
        int maxProfit = 0; // 最大利润
        if (prices == null || prices.length <= 0) return maxProfit;
        //
        int[][] dp = new int[times + 1][prices.length];
        for (int k = 1; k < times + 1; k++) {
            int tempMax = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] + tempMax);
                tempMax = Math.max(tempMax, dp[k - 1][i - 1] - prices[i]);

            }
        }
        maxProfit = dp[times][prices.length - 1];
        return maxProfit;
    }


    public static int maxProfitIII(int[] prices, int times) { //{7,1,5,3,6,4}
        int[][] DP = new int[times + 1][prices.length];  //
        for (int k = 1; k < times + 1; k++) {
            int tmpMax = -prices[0];  //初始记录如果这时候购买有多少利润，虽然血亏，最好还是记录一下，后面会被替换掉。
            for (int i = 1; i < prices.length; i++) {
                DP[k][i] = Math.max(DP[k][i - 1], prices[i] + tmpMax);
                tmpMax = Math.max(tmpMax, DP[k - 1][i - 1] - prices[i]); //找到最大利润购买时机
            }
        }
        return DP[times][prices.length - 1]; //返回最后一个状态
    }
}
