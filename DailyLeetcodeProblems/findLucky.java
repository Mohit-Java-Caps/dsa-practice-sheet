class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> frq = new HashMap<>();
        for(int num : arr){
            frq.put(num, frq.getOrDefault(num, 0) + 1);

        }
        int maxLucky = -1;
        for(Map.Entry<Integer, Integer> entry: frq.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();
            if(num == count){
                if(num > maxLucky){
                    maxLucky = num;
                }
            }
        }
        return maxLucky;
    }
}
