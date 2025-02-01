// https://leetcode.com/problems/search-a-2d-matrix/submissions/1481908720/
// HAVE SOLVED IT MYSELF

const searchMatrix = function (matrix, target) {
    const m = matrix.length;
    const n = matrix[0].length;

    for (let i = 0; i < m; i++) {
        if (matrix[i][n - 1] >= target) {
            let low = 0;
            let high = matrix[i].length - 1;
            let mid;
            while (high >= low) {
                mid = low + Math.floor((high - low) / 2);

                if (matrix[i][mid] === target) {
                    return true
                } else if (matrix[i][mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            return false;
        }
    }
    return false;
};

const matrix = [[1]];
const target = 1;

console.log(searchMatrix(matrix, target));
