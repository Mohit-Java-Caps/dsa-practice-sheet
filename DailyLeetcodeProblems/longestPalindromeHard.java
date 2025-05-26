class Solution {
    public int longestPalindrome(String[] words) {
        int[][] count = new int[26][26];
        int length = 0;
        boolean hasCenter = false;
 
        for (String word : words) {
            int a = word.charAt(0) - 'a';
            int b = word.charAt(1) - 'a';
 
            if (count[b][a] > 0) {
                // Pair found (reverse exists)
                length += 4;
                count[b][a]--;
            } else {
                count[a][b]++;
            }
        }
 
        // Check for a center palindromic word (like "gg", "aa")
        for (int i = 0; i < 26; i++) {
            if (count[i][i] > 0) {
                hasCenter = true;
                break;
            }
        }
 
        return hasCenter ? length + 2 : length;
    }
}
