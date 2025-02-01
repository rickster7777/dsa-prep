var maxArea = function (height) {
    let start = 0;
    let end = height.length - 1;
    const areas = [];

    while (start < end) {

        let leftX = start + 1;
        let leftY = height[start];
        
        let rightX= end + 1;
        let rightY = height[end];
        
        let horizontalWidth = Math.abs(rightX - leftX);
        let verticalWidth = Math.min(rightY, leftY);

        let area = horizontalWidth * verticalWidth;

        if (area > 0){
            areas.push(area);
        }
        
        if (height[start] < height[end]) {
            start++;
        } else {
            end--;
        }
    }

    return Math.max(...areas);
};


const height = [0,2];
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