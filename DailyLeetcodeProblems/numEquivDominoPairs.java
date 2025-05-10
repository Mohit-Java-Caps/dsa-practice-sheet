class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] freq = new int[100];
        int pairs = 0;
        for(int []d :dominoes ){
            int a = d[0], b = d[1];
            int key = (a < b) ? (a * 10 + b):(b *10 + a);

            pairs += freq[key];
            freq[key]++;
        }
        return pairs;
    }
}
