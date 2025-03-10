const disappeareNumbers = (nums) => {
    const s = new Set(nums);

    const arraySet = Array.from(s);

    //arraySet.sort((a, b) => a - b);

    const result = [];
    for (let i = 1; i <= nums.length; i++) {
        if (!s.has(i)) {

            result.push(i);
        }

    }
    return result;
}

const nums = [4, 3, 2, 7, 8, 2, 3, 1];
console.log(disappeareNumbers(nums));
//output should vbe 5, 6