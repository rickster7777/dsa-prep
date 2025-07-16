class RecentCounter {
    constructor() {
        this.requests = [];  // Store timestamps of recent requests
    }

    /** 
     * @param {number} t
     * @return {number}
     */
    ping(t) {
        // Add the new request timestamp to the array
        this.requests.push(t);

        // Remove timestamps that are outside the [t - 3000, t] range
        while (this.requests[0] < t - 3000) {
            this.requests.shift();  // Remove the first (oldest) element
        }

        // Return the number of requests within the last 3000 milliseconds
        return this.requests.length;
    }
}


var obj = new RecentCounter();  // Create an instance of RecentCounter

// Input arrays
var methodCalls = ["RecentCounter", "ping", "ping", "ping", "ping"];
var args = [[], [1], [100], [3001], [3002]];

// Iterate over the method calls and arguments
for (let i = 0; i < methodCalls.length; i++) {  // Start from 1 because the first is for object creation
    let method = methodCalls[i];
    let arg = args[i][0];  // Extract the argument (as it's wrapped in an array)

    if (method === "ping") {
        let result = obj.ping(arg);
        console.log(result);  // Output the result of each ping
    } else {
        console.log(null)
    }
}
