class Solution {
    public int longestSubsequence(int[] arr, int diff) {        
        int N = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        
        int max = 1;
        for(int i = 0; i < N; i++){
            map.put(arr[i],map.getOrDefault(arr[i]-diff,0)+1);
            max = Math.max(max, map.get(arr[i]));
        }        
        return max; 
    }
}