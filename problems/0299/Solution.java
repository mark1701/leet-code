class Solution {
    public String getHint(String secret, String guess) {
        
        int[] digits = new int[10];
        
        for(int i = 0; i < secret.length(); i++){
            char c = secret.charAt(i);
            if(c != guess.charAt(i))
                digits[Character.getNumericValue(c)]++;
        }
        
        int bulls = 0;
        int cows = 0;
        for(int i = 0; i < guess.length(); i++){
            char c = guess.charAt(i);
            if(secret.charAt(i) == guess.charAt(i)){
                bulls++;
                continue;
            }
            if(digits[Character.getNumericValue(c)] > 0){
                cows++;
                digits[Character.getNumericValue(c)]--;
            }
        }
        
        return bulls+"A"+cows+"B";
    }
}