class Solution {
    public int countLargestGroup(int n) {
        int maxSize = 0, result = 0;
        int[] count = new int[37];
        for(int i = 1;i<=n;i++){
            int sum = digitSum(i);
            count[sum]++;
        }
        for(int c : count){
            if(c > maxSize){
                maxSize = c;
                result = 1;
            }else if (c == maxSize){
                result++;
            }
        }
        return result;
    }

    private int digitSum(int num){
        int sum = 0;
        while(num != 0){
            sum += num %10;
            num /= 10;
        }

        return sum;
    }
}
