var equalPairs = function (grid) {
    const n = grid.length;
    let count = 0;

    // Loop through all rows and columns
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            let isEqual = true;
            // Compare row i with column j
            for (let k = 0; k < n; k++) {
                if (grid[i][k] !== grid[k][j]) {
                    isEqual = false;
                    break;
                }
            }
            if (isEqual) {
                count++;
            }
        }
    }

    return count;
};

// const  grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]



//Efficient solution using hashmap
var equalPairss = function (grid) {
    const n = grid.length;
    const rowMap = new Map();
    let count = 0;

    // Hash all rows and store their frequencies in rowMap
    for (let i = 0; i < n; i++) {
        let rowKey = grid[i].join(',');
        rowMap.set(rowKey, (rowMap.get(rowKey) || 0) + 1);
    }

    // Hash columns and check for matches with rows
    for (let j = 0; j < n; j++) {
        let col = [];
        for (let i = 0; i < n; i++) {
            col.push(grid[i][j]);
        }
        let colKey = col.join(',');

        // If the column exists in the rowMap, it means we found matches
        if (rowMap.has(colKey)) {
            count += rowMap.get(colKey);
        }
    }

    return count;

};

const grid = [[3, 2, 1], [1, 7, 6], [2, 7, 7]];
console.log(equalPairss(grid));
