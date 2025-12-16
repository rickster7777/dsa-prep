var setZeroes = function (matrix) {
    let m = matrix.length
    let n = matrix[0].length

    const zeroes = [];

    // Step 1: To identify cells where value is 0.
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (matrix[i][j] === 0) {
                zeroes.push([i, j]);
            }
        }
    }

    // Step 2: Use the zeroes array to set the corresponding rows and columns to zero
    for (let [i, j] of zeroes) {
        // Set the entire row to 0
        for (let col = 0; col < n; col++) {
            matrix[i][col] = 0;
        }

        // Set the entire column to 0
        for (let row = 0; row < m; row++) {
            matrix[row][j] = 0;
        }
    }

    // Return the modified matrix
    return matrix;
};



const matrix = [
    [0, 1, 2, 0],
    [3, 4, 5, 2],
    [1, 3, 1, 5]
];
console.log(setZeroes(matrix));