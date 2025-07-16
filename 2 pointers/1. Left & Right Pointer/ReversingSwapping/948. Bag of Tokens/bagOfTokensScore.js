var bagOfTokensScore = function (tokens, power) {
    tokens.sort(a, b => a - b);
    let score = 0;

    if (tokens[0] >= power) {
        return 0;
    } else {
        score++;
        for (;;) { }
    }

};

/**
 how to proceed further in this ??
 got the question
 but can't proceed
 */

/**
 🧠 Problem Understanding:
You're given:

A bag of tokens: each token has a cost (power required to play it).
An initial amount of power.

You start with 0 score.
You can play each token once, in one of two ways:
Face-up: Spend tokens[i] power → gain +1 score
Face-down: Spend -1 score → gain tokens[i] power

🎯 Goal:
Maximize your score by smartly choosing which tokens to play and how.

🧩 Key Strategy:
Sort the tokens in ascending order.
Use a greedy two-pointer approach:
Start with lo = 0 (cheapest token) and hi = tokens.length - 1 (most expensive token).

While lo <= hi, do:

If you have enough power, play token[lo]:

face-up:  power -= tokens[lo], score += 1, lo++

Else if you have at least 1 score, play token[hi] 
face-down: power += tokens[hi], score -= 1, hi--

Else: you can't make any more moves → break.
Track the max score seen so far.
 */

