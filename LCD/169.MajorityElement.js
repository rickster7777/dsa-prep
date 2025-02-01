// https://leetcode.com/problems/majority-element/submissions/1452204764/
// https://www.geeksforgeeks.org/boyer-moore-majority-voting-algorithm/

const majorityElement = (nums) => {
    let n = nums.length / 2;
    n = Math.floor(n);

    nums.sort((a, b) => (a - b));

    let init = nums[0];
    let count = 0;

    for (const i of nums) {
        if (init === i) {
            count++
            if (count > n) {
                return i;
            }
        } else {
            init = i;
            count++;
        }
    }

};


// beats 92%
var majorityElemen = function (nums) {
    let candidate = 0;
    let count = 0;

    for (let num of nums) {
        if (count === 0) {
            candidate = num;
            count++;
        }
        else if (num === candidate) {
            count++;
        } else {
            count--;
        }

    }

    return candidate;
};

// beats 100%
const moore = (nums) => {
    let count = 0, candidate = -1;

    // Finding majority candidate
    for (let index = 0; index < nums.length; index++) {
        if (count == 0) {
            candidate = nums[index];
            count = 1;
        }
        else {
            if (nums[index] == candidate)
                count++;
            else
                count--;
        }
    }

    return candidate;
}
const nums = [3, 2, 3];
console.log(moore(nums));


/**
 This algorithm works on the fact that if an element occurs more than N/2 times, it means that the remaining elements other than this 
 would definitely be less than N/2. So let us check the proceeding of the algorithm.

 When the elements are the same as the candidate element, votes are incremented whereas when some other element is found (not equal to the candidate element), 
 we decreased the count. This actually means that we are decreasing the priority of winning ability of the selected candidate, since we know that if the 
 candidate is in majority it occurs more than N/2 times and the remaining elements are less than N/2. We keep decreasing the votes since we found some different element(s) 
 than the candidate element. When votes become 0, this actually means that there are the equal  number of votes for different elements, which should not be the case for the 
 element to be the majority element. So the candidate element cannot be the majority and hence we choose the present element as the candidate and continue the same till all 
 the elements get finished. The final candidate would be our majority element. We check using the 2nd traversal to see whether its count is greater than N/2. If it is true, 
 we consider it as the majority element.


 */