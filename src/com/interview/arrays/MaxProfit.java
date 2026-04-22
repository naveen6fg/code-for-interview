package com.interview.arrays;

public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7, 1, 6, 5, 3, 10};
        int maxProfit = getMaxProfit(prices);
        System.out.println("Maximum Profit: " + maxProfit);
    }

    public static int getMaxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0; // Not enough data to calculate profit
        }

        int minPrice = prices[0];
        int maxProfit = 0; // Track the maximum profit

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // Update the minimum price
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice); // Update maximum profit
            }
        }

        return maxProfit;
    }
}
