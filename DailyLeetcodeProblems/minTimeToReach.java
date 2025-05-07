class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;
 
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0}); // {time, row, col}
 
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
 
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0], x = curr[1], y = curr[2];
 
            if (x == n -1   && y == m - 1) return time;
 
            if (time > dist[x][y]) continue;
 
            for (int[] dir : directions) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    int waitTime = Math.max(moveTime[nx][ny], time);
                    int arrivalTime = waitTime  + 1;
                    if (arrivalTime < dist[nx][ny]) {
                        dist[nx][ny] = arrivalTime;
                        pq.offer(new int[]{arrivalTime, nx, ny});
                    }
                }
            }
        }
 
        return -1; // If destination is unreachable
    }
}
