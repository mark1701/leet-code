class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int n : nums) sum+= n;
        int N = nums.length;
        return ((N*(N+1))/2) - sum;
    }
}