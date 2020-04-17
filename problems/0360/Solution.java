class Solution {
    int a, b, c;
    
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        
        int[] res = new int[nums.length];
        int N = nums.length;
               
        int idx = a < 0 ? 0 : N - 1;
        int left = 0, right = N - 1;
        
        while(idx < N && idx >= 0){            
            if(a >= 0){
                res[idx--] = f(nums[left]) >= f(nums[right]) ? f(nums[left++]) : f(nums[right--]);
            }else{
                res[idx++] = f(nums[left]) <= f(nums[right]) ? f(nums[left++]) : f(nums[right--]);
            }            
        }       
        
        return res;
    }
    
    private int f(int x){
        return a*x*x+b*x+c;
    }
}