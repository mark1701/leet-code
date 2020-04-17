class Solution {
    public String findContestMatch(int n) {
    
        String[] teams = new String[n];
        
        for(int i = 0; i < n; i++){
            teams[i] = String.valueOf(i + 1);
        }
    
        int mid = n / 2;
        
        while(n > 0){
            for(int i = 0; i < n/2; i++){
                teams[i] = "(" + teams[i] + "," + teams[n-1-i] + ")";
            }
            n /= 2;                

        }
    
        return teams[0];
    }
}