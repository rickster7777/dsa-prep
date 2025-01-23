// This solution beats only 18%
var maxOperations = function (nums, k) {
    nums.sort((a, b) => (a - b));

    let start = 0;
    let end = nums.length - 1;
    let output = 0;

    while (start < end) {
        if (nums[start] + nums[end] === k) {
            output++;
            start++;
            end--;
        } else if (nums[start] + nums[end] < k) {
            start++;
        } else {
            end--;
        }
    }

    return output;
};


//This gpt solution beats 78.48%
var maxOperations = function(nums, k) {
    let freq = new Map();
    let operations = 0;

    for (let num of nums) {
        // Calculate the complement for the current number
        let complement = k - num;

        // Check if we already have the complement in the map to form a pair
        if (freq.has(complement) && freq.get(complement) > 0) {
            operations++;
            // Decrease the frequency of the complement
            freq.set(complement, freq.get(complement) - 1);
        } else {
            // If not, we add the current number to the map
            freq.set(num, (freq.get(num) || 0) + 1);
        }
    }

    return operations;
};


//3rd solution

var maxOperations = function(nums, k) {
    let map = new Map();
    
    let count = 0;
    for(let num of nums){
        let target = k - num;
        if(map.has(target) && map.get(target) > 0){
            count++;
            map.set(target , map.get(target)-1)
        }else{
            map.set(num , (map.get(num) || 0) + 1 )
        }
    }
 return count;
};