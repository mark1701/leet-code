class Solution {
    public int longestMountain(int[] A) {
        int N = A.length, res = 0;
        int[] up = new int[N], down = new int[N];
        for (int i = N - 2; i >= 0; --i) if (A[i] > A[i + 1]) down[i] = down[i + 1] + 1;
        for (int i = 0; i < N; ++i) {
            if (i > 0 && A[i] > A[i - 1]) up[i] = up[i - 1] + 1;
            if (up[i] > 0 && down[i] > 0) res = Math.max(res, up[i] + down[i] + 1);
        }
        return res;
    }
}

// improved to 1-pass

    public int longestMountain(int[] A) {
        int res = 0, up = 0, down = 0;
        for (int i = 1; i < A.length; ++i) {
            if (down > 0 && A[i - 1] < A[i] || A[i - 1] == A[i]) up = down = 0;
            if (A[i - 1] < A[i]) up++;
            if (A[i - 1] > A[i]) down++;
            if (up > 0 && down > 0 && up + down + 1 > res) res = up + down + 1;
        }
        return res;
    }

// more intuitive

	int longestMountain(vector<int>& A) {
        int maxMnt = 0;
    
        int i = 1;
        while (i < A.size()) {
            while(i < A.size() && A[i-1] == A[i])
                ++i;
            
            int up = 0;
            while(i < A.size() && A[i-1] < A[i]) {
                ++up;
                ++i;
            }
            
            int down = 0;
            while(i < A.size() && A[i-1] > A[i]) {
                ++down;
                ++i;
            }
            
            if (up > 0 && down > 0)  
                maxMnt = max(maxMnt, up+down+1);
            
        }
        
        return maxMnt;
    }