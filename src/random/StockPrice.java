package com.random;

public class StockPrice {

    private static void calc(int[] prices) {

        int minBuySoFar = Integer.MAX_VALUE;
        int profit = 0;

        for (int i=0; i<prices.length; i++) {
            profit = Math.max(profit, prices[i] - minBuySoFar );
            minBuySoFar = Math.min(prices[i], minBuySoFar);
        }

    }


    public static void main(String args[]) {

        int prices[] = {100, 80, 60, 44, 60, 64, 20};
        calc(prices);

        System.out.println();
    }

}
