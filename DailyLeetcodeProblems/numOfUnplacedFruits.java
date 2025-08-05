class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int m = baskets.length;

        boolean[] used = new boolean[m];
        int unplaced = 0;

        for(int i = 0;i<n;i++){
            boolean placed = false;

            for(int j = 0;j<m;j++){
                if(!used[j] && baskets[j] >= fruits[i]){

                    used[j] = true;
                    placed = true;
                    break;
                }
            }
            if(!placed){
                unplaced++;
            }
        }
        return unplaced;
    }
}
