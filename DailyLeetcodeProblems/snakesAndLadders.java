class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[]  visited = new boolean[n * n + 1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1,0});
        visited[1]= true;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cell = curr[0], moves = curr[1];
            if(cell == n* n) return moves;

            for(int next = cell +1;next <= Math.min(cell + 6, n* n);next++){
                int[] rc = getCoordinates(next, n);
                int r = rc[0], c = rc[1];
                int dest = board[r][c]  == -1? next:board[r][c];
                if(!visited[dest]){
                    visited[dest] = true;
                    q.offer(new int[]{dest, moves + 1});
                }
            }
        }
        return -1;
    }
    private int[] getCoordinates(int cell, int n){
        int row = n-1-(cell - 1)/n;
        int col = (cell -1) % n;
        if((n - row) % 2 == 0) col = n-1-col;
        return new int[]{row, col};
    }
}
