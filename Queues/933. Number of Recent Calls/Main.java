import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    private Queue<Integer> requests;  // Queue to store timestamps of recent requests

    // Constructor to initialize the queue
    public RecentCounter() {
        this.requests = new LinkedList<>();
    }

    // Method to add a request timestamp and return the number of requests in the last 3000 milliseconds
    public int ping(int t) {
        // Add the new request timestamp to the queue
        requests.offer(t);

        // Remove timestamps that are outside the [t - 3000, t] range
        while (requests.peek() < t - 3000) {
            requests.poll();  // Remove the first (oldest) element
        }

        // Return the number of requests within the last 3000 milliseconds
        return requests.size();
    }
}


public class Main {
    public static void main(String[] args) {
        // Create an instance of RecentCounter
        RecentCounter obj = new RecentCounter();
        
        // Call the ping method with different timestamps and print the results
        System.out.println(obj.ping(1));      // Output: 1
        System.out.println(obj.ping(100));    // Output: 2
        System.out.println(obj.ping(3001));   // Output: 3
        System.out.println(obj.ping(3002));   // Output: 3
    }
}
