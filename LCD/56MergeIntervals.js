var merge = function (intervals) {

    if (intervals.length <= 1) {
        return intervals
    }
    const size = intervals[0].length - 1;

    for (let i = 0; i < intervals.length; i++) {
        if (intervals[i][size] <= intervals[i + 1][0]) {
            
        }
    }
};

const intervals = [[1, 3], [2, 6], [8, 10], [15, 18]];
