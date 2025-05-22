class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
         int n = nums.length;
        Arrays.sort(queries, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> available = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> running = new PriorityQueue<>();
        int queryIndex = 0;
        int usedQueries = 0;
 
        for (int i = 0; i < n; i++) {
            // Add queries starting at or before i to available
            while (queryIndex < queries.length && queries[queryIndex][0] <= i) {
                available.offer(queries[queryIndex][1]);
                queryIndex++;
            }
 
            // Remove queries from running that have ended before i
            while (!running.isEmpty() && running.peek() < i) {
                running.poll();
            }
 
            // Apply queries as needed to cover nums[i]
            while (nums[i] > running.size()) {
                if (available.isEmpty() || available.peek() < i) {
                    return -1;
                }
                running.offer(available.poll());
                usedQueries++;
            }
        }
 
        return queries.length - usedQueries;
    }
}
