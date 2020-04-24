class Solution {
    
    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[0] = 1;
        G[1] = 1;
        
        for(int l = 2; l <= n; l++){
            for(int i = 0; i <= l; i++){
                G[l] += G[i-1] * G[l-i];
            }
        }
        
        return G[n];
    }
}