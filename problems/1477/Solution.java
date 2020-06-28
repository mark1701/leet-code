class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int N = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i = 0; i < N; i++){
            sum += arr[i];
            map.put(sum, i);
        }
        map.put(0, -1);
        
        sum = 0;

        int len = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++){
            sum += arr[i];
            if(map.containsKey(sum-target)){
                len = Math.min(len,i - map.get(sum-target));
            }    
            
            if(len < Integer.MAX_VALUE && map.containsKey(sum + target)){
                res = Math.min(res, len + (map.get(sum+target) - i));
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}