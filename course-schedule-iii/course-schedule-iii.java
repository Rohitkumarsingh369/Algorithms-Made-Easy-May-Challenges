class Solution {
    public int scheduleCourse(int[][] courses) {
        // Sort the courses by their deadlines
        // (Greedy! We have to deal with courses with early deadlines first)
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        // The current time
        int time = 0;
        for (int[] course : courses) {
            // Add current course duration to current time
            time += course[0];
            // Add current course duration to priority queue (maxHeap)
            maxHeap.offer(course[0]);
            // If time exceeds, drop the previous course which costs the most time.
            // (Greedy! It must be the best choice!)
            if (time > course[1]) {
                time -= maxHeap.poll();
            }
        }
        return maxHeap.size();
    
    }
}