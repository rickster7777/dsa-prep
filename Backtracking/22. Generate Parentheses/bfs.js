var generateParenthesis = function(n) {
    const result = [];
    const queue = [];

    // Initial state: empty string with 0 open and close
    queue.push({ str: '', open: 0, close: 0 });

    while (queue.length > 0) {
        const { str, open, close } = queue.shift();

        // ✅ Base case: if we have 3 open and 3 close → valid string
        if (str.length === 2 * n) {
            result.push(str);
            continue;
        }

        // ➕ Add '(' if we can
        if (open < n) {
            queue.push({ str: str + '(', open: open + 1, close: close });
        }

        // ➕ Add ')' only if it won't break the validity
        if (close < open) {
            queue.push({ str: str + ')', open: open, close: close + 1 });
        }
    }

    return result;
};


console.log(generateParenthesis(3));