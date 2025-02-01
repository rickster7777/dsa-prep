// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

var maxProfit = function (prices) {
    let minPrice = Infinity;  // Start with a very high value for minPrice
    let maxProfit = 0;  // Start with 0 profit

    for (let i = 0; i < prices.length; i++) {
        // Update the minimum price encountered so far
        if (prices[i] < minPrice) {
            minPrice = prices[i];
        }

        // Calculate the potential profit if we sell on the current day
        const profit = prices[i] - minPrice;

        // Update maxProfit if the current profit is greater than the previously recorded maxProfit
        if (profit > maxProfit) {
            maxProfit = profit;
        }
    }

    return maxProfit;
};

const prices = [7, 1, 5, 3, 6, 4];
console.log(maxProfit(prices));