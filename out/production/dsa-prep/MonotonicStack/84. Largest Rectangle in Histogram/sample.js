// var largestRectangleArea = function (heights) {
//     let max2 
//     if (heights.length > 1) {
//         heights.sort();
//         max2 = heights[heights.length - 2];
//     }else{
//         max2 = heights[heights.length - 1];
//     }


//     return max2 === 0 ? 0 : max2 * 2;
// };


var largestRectangleArea = function (heights) {
    const stack = [];         // Stack to store indices of the bars
    let maxArea = 0;

    heights.push(0);          // Add a sentinel bar of height 0 to flush out remaining bars in stack

    for (let i = 0; i < heights.length; i++) {
        // While the current bar is smaller than the one at the top of the stack
        while (stack.length > 0 && heights[i] < heights[stack[stack.length - 1]]) {
            // Pop the top height index from the stack
            const topIndex = stack.pop();
            const height = heights[topIndex];

            // Calculate the width: if stack is empty, width is i (entire left side),
            // else it's the distance between current index and element on top of the stack - 1
            const width = stack.length === 0 ? i : i - stack[stack.length - 1] - 1;

            // Calculate area and update maxArea
            const area = height * width;
            maxArea = Math.max(maxArea, area);
        }

        // Push current index onto the stack
        stack.push(i);
    }

    return maxArea;
};

const heights = [2, 1, 5, 6, 2, 3];
console.log(largestRectangleArea(heights));