class Solution {
      public long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;
 
        int len = 1;
 
        while (count < n) {
            // Odd length palindromes
            for (int half = (int)Math.pow(10, len - 1); count < n && half < (int)Math.pow(10, len); half++) {
                long pal = buildPalindrome(half, true);
                if (isKPalindrome(pal, k)) {
                    sum += pal;
                    count++;
                }
            }
 
            // Even length palindromes
            for (int half = (int)Math.pow(10, len - 1); count < n && half < (int)Math.pow(10, len); half++) {
                long pal = buildPalindrome(half, false);
                if (isKPalindrome(pal, k)) {
                    sum += pal;
                    count++;
                }
            }
 
            len++;
        }
 
        return sum;
    }
 
    // Build palindrome from half
    private long buildPalindrome(int half, boolean isOdd) {
        String s = String.valueOf(half);
        StringBuilder sb = new StringBuilder(s);
        if (isOdd) sb.setLength(sb.length() - 1);  // skip middle digit for odd
        sb.reverse();
        return Long.parseLong(s + sb.toString());
    }
 
    // Check if number is a palindrome in base k
    private boolean isKPalindrome(long num, int k) {
        String baseK = toBaseK(num, k);
        int l = 0, r = baseK.length() - 1;
        while (l < r) {
            if (baseK.charAt(l++) != baseK.charAt(r--)) return false;
        }
        return true;
    }
 
    private String toBaseK(long num, int k) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % k);
            num /= k;
        }
        return sb.toString();
    }
}
