// This is the more optimized solution

// Dry run on paper to understand it better.

var setZeroes = function (matrix) {
    let m = matrix.length;
    let n = matrix[0].length;

    let firstRowZero = false;
    let firstColZero = false;

    // Step 1: Check if the first row or first column has any zeros
    for (let i = 0; i < m; i++) {
        if (matrix[i][0] === 0) {
            firstColZero = true;
            break;
        }
    }

    for (let j = 0; j < n; j++) {
        if (matrix[0][j] === 0) {
            firstRowZero = true;
            break;
        }
    }

    // Step 2: Use the first row and first column to mark rows and columns
    for (let i = 1; i < m; i++) {
        for (let j = 1; j < n; j++) {
            if (matrix[i][j] === 0) {
                matrix[i][0] = 0;  // Mark the first element of the row
                matrix[0][j] = 0;  // Mark the first element of the column
            }
        }
    }

    // Step 3: Zero out cells based on the markers in the first row and first column
    for (let i = 1; i < m; i++) {
        for (let j = 1; j < n; j++) {
            if (matrix[i][0] === 0 || matrix[0][j] === 0) {
                matrix[i][j] = 0;
            }
        }
    }

    // Step 4: Zero out the first row if needed
    if (firstRowZero) {
        for (let j = 0; j < n; j++) {
            matrix[0][j] = 0;
        }
    }

    // Step 5: Zero out the first column if needed
    if (firstColZero) {
        for (let i = 0; i < m; i++) {
            matrix[i][0] = 0;
        }
    }
};


const matrix = [
    [1, 1, 1],
    [1, 0, 1],
    [1, 1, 1]
];