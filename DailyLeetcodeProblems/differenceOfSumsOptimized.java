class Solution {
    public int differenceOfSums(int n, int m) {
        int totalSum = n*(n+1)/2;
        int k = n/m;
        int divsum = m * k *(k+1)/2;
        return totalSum - 2 * divsum;
    }
}
