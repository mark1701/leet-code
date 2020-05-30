class Solution {
    
    private final Double eps = 0.001;
    
    public boolean judgePoint24(int[] nums) {
        
        List<Double> numsD = new ArrayList<>();
        for(int n : nums) numsD.add((double) n);
        
        return calculator(numsD);
    }    
    
    private boolean calculator(List<Double> nums){
        
        if(nums.size() == 1)
            return (Math.abs(nums.get(0) - 24.0)) <= eps;
        
        for(int i = 0; i < nums.size(); i++){
            for(int j = i+1; j< nums.size(); j++){
                List<Double> results = generateResults(nums.get(i), nums.get(j));
                List<Double> next = new ArrayList<>();
                for(int k = 0; k < nums.size(); k++)
                    if(k != i && k != j) next.add(nums.get(k));
                
                for(Double r : results){
                    next.add(r);
                     if(calculator(next)) return true;
                    next.remove(r);
                }
            }
        }
        return false;        
    }
    
    
    private List<Double> generateResults(Double a, Double b){
        List<Double> res = new ArrayList<>();
        res.add(a+b);
        res.add(a-b);
        res.add(b-a);
        res.add(a*b);
        if(Math.abs(b) > eps) res.add(a/b);
        if(Math.abs(a) > eps) res.add(b/a);
        return res;
    }
}