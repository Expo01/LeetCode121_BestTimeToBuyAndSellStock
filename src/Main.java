/*You are given an array prices where prices[i] is the price of a given stock on the ith day.

        You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

        Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.


        logic:
        can only numbers after current number since can only sell in the future. could use the nested for loop for
        O(n^2) solution and have j start at i+1 no avoid same day sell or going back in time, but we don't want the
        poor time complexity. whereas with two sum, we knew the desired sum prior to looping. in this case, we need
        a temporary variable that will be modified with an if conditional. in the nested for loop, start temp = 0. then
        if array[j] - array [i]  is > temp, temp = the difference.

        for the map version. if the value of array[i]- key, then temp = array[i] - map key. unlike two sum, i want to
        return the value of max profit, not the buy and sell days

 */




public class Main {
    public static void main(String[] args) {

    }
}

// nested loop O(n^2) solution
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            for(int j = i+1; j < prices.length; j++){
                if ((prices[j] - prices[i]) > maxProfit){
                    maxProfit = prices[j] - prices[i];
                }
            }
        }
        return maxProfit;
    }
}