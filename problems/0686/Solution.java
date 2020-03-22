class Solution {
    public int repeatedStringMatch(String a, String b) {
        //a.length() = N, b.length() = M
        
        int count  = 0;
        StringBuilder sb = new StringBuilder();
        
        while(sb.length() < b.length()){
            sb.append(a); //O(roundUp(M/N) * N) < O(M*N)
            count++;
        }
        
        if(sb.indexOf(b) != -1) return count; //check at max O(M*N) characters
        
        //handles rotated array case
        if(sb.append(a).indexOf(b) != -1) return count + 1; //append takes O(N), indexOf takes in the worst case (missing match) ~O(M*N)
        
        return -1;
    }
}