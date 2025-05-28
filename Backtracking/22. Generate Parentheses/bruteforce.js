var generateParenthesis = function(n) {
    const result = [];

    function isValid(str) {
        let balance = 0;
        for (let ch of str) {
            if (ch === '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return balance === 0;
    }

    function generateAll(current) {
        if (current.length === 2 * n) {
            if (isValid(current)) result.push(current);
            return;
        }

        generateAll(current + '(');
        generateAll(current + ')');
    }

    generateAll('');
    return result;
};

console.log(generateParenthesis(3));
