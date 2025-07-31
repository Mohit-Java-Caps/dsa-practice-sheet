class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> curr = new HashSet<>();

        for(int num : arr){
            Set<Integer> next = new HashSet<>();
            next.add(num);
            for(int val : curr){
                next.add(val | num);
            }
            res.addAll(next);
            curr = next;
        }
        return res.size();

    }
}
