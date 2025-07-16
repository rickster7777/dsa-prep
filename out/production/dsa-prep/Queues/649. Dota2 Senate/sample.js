//https://leetcode.com/problems/dota2-senate/?envType=study-plan-v2&envId=leetcode-75

var predictPartyVictory = function (senate) {
    // Queues to track the indices of the senators for each party
    let radiant = [];
    let dire = [];

    // Add the initial senators to their respective queues
    for (let i = 0; i < senate.length; i++) {
        if (senate[i] === 'R') {
            radiant.push(i);
        } else {
            dire.push(i);
        }
    }

    // Simulate the rounds
    while (radiant.length > 0 && dire.length > 0) {
        // Get the next senator from each party
        let radiantSenator = radiant.shift();
        let direSenator = dire.shift();

        // The senator with the smaller index gets to ban the other senator
        if (radiantSenator < direSenator) {
            // Radiant senator bans Dire senator, requeue the Radiant senator
            radiant.push(radiantSenator + senate.length);
        } else {
            // Dire senator bans Radiant senator, requeue the Dire senator
            dire.push(direSenator + senate.length);
        }
    }

    // If Radiant's queue is empty, Dire wins, otherwise Radiant wins
    return radiant.length > 0 ? "Radiant" : "Dire";
};
