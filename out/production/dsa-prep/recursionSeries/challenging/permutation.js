const permutation = (nums, index, ans) => {
    if (index >= nums.length) {
        ans.push([...nums]);  // Make a copy of the array
        return;
    }

    for (let j = index; j < nums.length; j++) {
        let temp = nums[index];
        nums[index] = nums[j];
        nums[j] = temp;

        permutation(nums, index+1, ans);

        temp = nums[index];
        nums[index] = nums[j];
        nums[j] = temp;

    }
};

const nums = ["a", "b", "c"];
const index = 0;
const ans = [];

permutation(nums, index, ans)

console.log(ans);
