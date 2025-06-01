class Solution {
    public long distributeCandies(int n, int limit) {
        long total = comb(n+2, 2);

        //Substract overlimit comibations
        for(int i = 0;i<3;i++){
            int over = n - (limit + 1);
            if(over >= 0){
                total -=  comb(over + 2, 2);
            }
        }

        int over2 = n - 2 *(limit + 1);
        if(over2 >= 0){
            total += 3L * comb(over2+2, 2);
        }

        int over3 = n - 3 *(limit + 1);
        if(over3 >= 0){
            total -=  comb(over3 +2, 2);
        }
        return total;
    }

    private long comb(int n, int k){
        if(n < k) return 0;
        if(k == 0 || k == n) return 1;
        if(k == 1) return n;
        if(k==2){
            return (long) n * (n-1)/2;
        }
        return 0;
    }
}
