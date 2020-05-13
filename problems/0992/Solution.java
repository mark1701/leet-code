class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        return subArrays(A, K) - subArrays(A,K-1);
    }
    
    private int subArrays(int[] A, int k){
        
        int N = A.length;
        Map<Integer,Integer> used = new HashMap<>();
        
        int i = 0, count = 0;
        
        for(int j = 0; j < N; j++){
            if(!used.containsKey(A[j])) k--;
            
            used.put(A[j], used.getOrDefault(A[j],0)+1);
                     
            while(k < 0){
                used.put(A[i], used.get(A[i])-1);
                if(used.get(A[i]) == 0){
                    k++;
                    used.remove(A[i]);
                }
                i++;
            }
            
            count += j - i +1;                    
                     
        }
        return count;
    }
}