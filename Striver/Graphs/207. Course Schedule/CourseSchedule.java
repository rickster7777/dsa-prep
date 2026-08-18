/*
Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
*/

import java.util.*;

public class CourseSchedule {

    /**
     * Determines whether all courses can be completed.
     *
     * @param numCourses    Total number of courses.
     * @param prerequisites Each pair [a, b] means:
     *                      To take course 'a', you must first complete course 'b'.
     * @return true if all courses can be completed, otherwise false.
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        // ============================================================
        // STEP 1: Create the graph (Adjacency List)
        // ============================================================
        //
        // Graph representation:
        // prerequisite -----> course
        //
        // Example:
        // prerequisites = [[1,0],[2,0],[3,1],[3,2]]
        //
        // Graph:
        // 0 -> 1
        // 0 -> 2
        // 1 -> 3
        // 2 -> 3
        //
        // graph.get(i) stores all courses that depend on course i.
        //
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // ============================================================
        // STEP 2: Create an indegree array.
        // ============================================================
        //
        // indegree[i] = Number of prerequisites required before
        // taking course i.
        //
        // Initially every course has 0 prerequisites.
        //
        int[] indegree = new int[numCourses];

        // ============================================================
        // STEP 3: Build the graph and calculate indegrees.
        // ============================================================
        //
        // For each prerequisite:
        //
        // [course, prerequisite]
        //
        // Add an edge:
        // prerequisite -----> course
        //
        // Also increase indegree of the course.
        //
        for (int[] pre : prerequisites) {

            int course = pre[0];
            int prerequisite = pre[1];

            graph.get(prerequisite).add(course);

            indegree[course]++;
        }

        // ============================================================
        // STEP 4: Add all courses having indegree 0 into the queue.
        // ============================================================
        //
        // These courses have no prerequisites.
        // Therefore, they can be taken immediately.
        //
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {

            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Number of successfully completed courses.
        int visited = 0;

        // ============================================================
        // STEP 5: Perform BFS (Kahn's Algorithm)
        // ============================================================
        //
        // Keep taking courses whose prerequisites are completed.
        //
        while (!queue.isEmpty()) {

            // Remove one available course
            int current = queue.poll();

            // Mark it as completed
            visited++;

            // Visit all courses depending on this course
            for (int neighbor : graph.get(current)) {

                // One prerequisite has now been completed
                indegree[neighbor]--;

                // If all prerequisites are completed,
                // this course becomes available.
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // ============================================================
        // STEP 6: Final Answer
        // ============================================================
        //
        // If every course has been visited,
        // there is NO cycle.
        //
        // Otherwise,
        // some courses are stuck in a cycle.
        //
        return visited == numCourses;
    }

    // ============================================================
    // Main Method
    // ============================================================
    public static void main(String[] args) {

        // Example 1
        int numCourses1 = 2;
        int[][] prerequisites1 = {
                {1, 0}
        };

        System.out.println("Example 1:");
        System.out.println(canFinish(numCourses1, prerequisites1));
        // Expected Output: true


        // Example 2
        int numCourses2 = 2;
        int[][] prerequisites2 = {
                {1, 0},
                {0, 1}
        };

        System.out.println("\nExample 2:");
        System.out.println(canFinish(numCourses2, prerequisites2));
        // Expected Output: false


        // Example 3
        int numCourses3 = 4;
        int[][] prerequisites3 = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };

        System.out.println("\nExample 3:");
        System.out.println(canFinish(numCourses3, prerequisites3));
        // Expected Output: true
    }
}

/*
How it works

For prerequisites = [[1,0],[2,0],[3,1],[3,2]]

The graph is:

0 → 1
0 → 2
1 → 3
2 → 3

Initial indegree:

Course:    0 1 2 3
Indegree:  0 1 1 2

Queue initially:

[0]

Processing:

Queue	Process	Indegree After
[0]	0	[0,0,0,2]
[1,2]	1	[0,0,0,1]
[2]	2	[0,0,0,0]
[3]	3	Done

Visited courses = 4, which equals numCourses, so return true.

Complexity
Time: O(V + E) where V = numCourses and E = prerequisites.length
Space: O(V + E) for the adjacency list, indegree array, and queue.
*/