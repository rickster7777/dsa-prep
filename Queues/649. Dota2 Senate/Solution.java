import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String predictPartyVictory(String senate) {
        // Queues to track the indices of the senators for each party
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        
        // Add the initial senators to their respective queues
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        
        // Simulate the rounds
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            // Get the next senator from each party
            int radiantSenator = radiant.poll();
            int direSenator = dire.poll();
            
            // The senator with the smaller index gets to ban the other senator
            if (radiantSenator < direSenator) {
                // Radiant senator bans Dire senator, requeue the Radiant senator
                radiant.offer(radiantSenator + senate.length());
            } else {
                // Dire senator bans Radiant senator, requeue the Dire senator
                dire.offer(direSenator + senate.length());
            }
        }
        
        // If Radiant's queue is empty, Dire wins, otherwise Radiant wins
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
