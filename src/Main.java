/*You are given an array prices where prices[i] is the price of a given stock on the ith day.

        You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

        Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.


        logic:
        can only numbers after current number since can only sell in the future. could use the nested for loop for
        O(n^2) solution and have j start at i+1 no avoid same day sell or going back in time, but we don't want the
        poor time complexity. whereas with two sum, we knew the desired sum prior to looping. in this case, we need
        a temporary variable that will be modified with an if conditional. in the nested for loop, start temp = 0. then
        if array[j] - array [i]  is > temp, temp = the difference.

     //map not appropriate here. map only allows for exact values or keys to be searched. No > < such that if i were
     // so search a map for a range of values that could result in higher profit, i can't do it
        y-x > z. we need to make this true so....
        y-z > x
 */


import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] priceArray = {5, 50, 4, 7};
        System.out.println(new Solution().maxProfit(priceArray));
    }
}

//to avoid nested loop, need 3 variables. one to save prior low, one saves max profit potential and one variable is current
// to compare to max profit
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int lowestValueSoFar = Integer.MAX_VALUE;
        int profitIfSoldToday = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lowestValueSoFar){
                lowestValueSoFar = prices[i];
            }

            profitIfSoldToday = prices[i] - lowestValueSoFar;

            if (profitIfSoldToday > maxProfit){
                maxProfit = profitIfSoldToday;
            }

        }
        return maxProfit;
    }
}

// nested loop O(n^2) solution
//class Solution {
//    public int maxProfit(int[] prices) {
//        int maxProfit = 0;
//        for(int i = 0; i < prices.length; i++){
//            for(int j = i+1; j < prices.length; j++){
//                if ((prices[j] - prices[i]) > maxProfit){
//                    maxProfit = prices[j] - prices[i];
//                }
//            }
//        }
//        return maxProfit;
//    }
//}