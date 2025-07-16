function minFlips(a, b, c) {
    let flips = 0;

    // Iterate over each bit position (0 to 31, assuming 32-bit integers)
    for (let i = 0; i < 32; i++) {
        let bitA = (a >> i) & 1; // Get the i-th bit of a
        let bitB = (b >> i) & 1; // Get the i-th bit of b
        let bitC = (c >> i) & 1; // Get the i-th bit of c

        if (bitC === 0) {
            // Case 1: c[i] = 0, both a[i] and b[i] must be 0
            if (bitA === 1) flips++; // Flip bitA to 0
            if (bitB === 1) flips++; // Flip bitB to 0
        } else {
            // Case 2: c[i] = 1, either a[i] or b[i] or both must be 1
            if (bitA === 0 && bitB === 0) {
                flips++; // Flip either a[i] or b[i] to 1
            }
        }
    }

    return flips;
}
