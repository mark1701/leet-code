class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        
        int N  = hand.length;
        if(N % W != 0) return false;
        int G = N / W;
        
        Arrays.sort(hand);
        
        int groups = 0;
        for(int i = 0; i < N; i++){
            if( hand[i] == -1) continue;
            
            int curr = hand[i];
            hand[i] = -1;
            
            int count = 1;
            for(int j = i+1; j < N; j++){
                if(count == W) break;
                if(j == N || hand[j] == -1) continue;
                
                    
                if(hand[j] == curr+1){
                    curr++;
                    
                    hand[j] = -1;
                    count++;
                    if(count == W) break;
                }
            }

            if(count != W) return false;
            groups++;
        }
        return groups == G;
    }
}