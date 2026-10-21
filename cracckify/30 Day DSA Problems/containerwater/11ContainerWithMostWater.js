//have solved it myself
//catch was to use area of a rectangle coordinates formula

var maxArea = function (height) {
    let start = 0; // Pointer at the beginning of the array
    let end = height.length - 1; // Pointer at the end of the array
    const areas = []; // Stores all possible area values

    while (start < end) { // Continue until pointers meet
        // Calculate the (x, y) coordinates of the left and right container walls
        let leftX = start + 1;  // X-coordinate of the left pointer (1-based index)
        let leftY = height[start]; // Height of the left pointer

        let rightX = end + 1;  // X-coordinate of the right pointer (1-based index)
        let rightY = height[end]; // Height of the right pointer

        // Calculate width (horizontal distance between two lines)
        let horizontalWidth = Math.abs(rightX - leftX);

        // Calculate height (minimum of two heights to ensure container holds water)
        let verticalWidth = Math.min(rightY, leftY);

        // Calculate the area of the container
        let area = horizontalWidth * verticalWidth;

        // Store the area if it’s greater than zero
        if (area > 0) {
            areas.push(area);
        }

        // Move the pointer that has the smaller height
        // This is because a taller line may potentially hold more water
        if (height[start] < height[end]) {
            start++; // Move left pointer forward
        } else {
            end--; // Move right pointer backward
        }
    }

    // Return the maximum area found
    return Math.max(...areas);
};


//const height = [0, 2];
const height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
console.log(maxArea(height));




//More optimized approach

var maxArea = function (height) {
    let start = 0;
    let end = height.length - 1;
    let maxArea = 0;

    while (start < end) {
        // Calculate the area between the bars at 'start' and 'end'
        let width = end - start;
        let minHeight = Math.min(height[start], height[end]);
        let area = width * minHeight;

        // Update maxArea if we find a larger area
        maxArea = Math.max(maxArea, area);

        // Move the pointer pointing to the shorter bar inward
        if (height[start] < height[end]) {
            start++;
        } else {
            end--;
        }
    }

    return maxArea;
};