package LEETCODE.FinalPricesWithaSpecialDiscountinaShop;

public class Solution {
    public int[] finalPrices(int[] prices) {
        for(int left = 0; left < prices.length; left++) {
            for(int right = left+1; right < prices.length; right++) {
                if(prices[right] <= prices[left]) {
                    prices[left] = prices[left] - prices[right];
                    break;
                }
            }
        }
        return prices;
    }
}
