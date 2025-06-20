class Solution {
    public int maxDistance(String s, int k) {
        int n = s.length();
        int x = 0, y = 0, max = 0;

        for(int i = 0;i<n;i++){
            char move = s.charAt(i);
            if(move == 'N') y++;
            else if(move == 'S') y--;
            else if(move == 'E') x++;
            else if(move == 'W') x--;

            int dist = Math.abs(x) + Math.abs(y);

            max = Math.max(max, Math.min(dist + 2 * k, i+1));
        }
        return max;
    }
}
