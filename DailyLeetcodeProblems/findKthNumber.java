class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--; // convert to 0-based index
        while (k > 0) {
            long steps = 0, first = curr, last = curr + 1;
            // Count numbers in current level of the trie
            while (first <= n) {
                steps += Math.min((long)n + 1, last) - first;
                first *= 10;
                last *= 10;
            }
            
            if (steps <= k) {
                // Move to next sibling
                curr++;
                k -= steps;
            } else {
                // Move to first child
                curr *= 10;
                k--;
            }
        }
        return curr;
    }
}
