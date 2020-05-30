class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int N = nums.length;
        Map<Integer, Integer> count = new HashMap<>();        
        for(int n : nums)
            count.put(n, count.getOrDefault(n, 0)+1);
                
        Map<Integer, List<Integer>> frequencies = new HashMap<>();
        for(int element : count.keySet()){
            int freq = count.get(element);
            List<Integer> elements = frequencies.getOrDefault(freq, new ArrayList<>());
            elements.add(element);
            frequencies.put(freq, elements);
        }
        
        List<Integer>[] distributions = (ArrayList<Integer>[]) new ArrayList[N+1];
        for(int freq : frequencies.keySet())
            distributions[freq] = frequencies.get(freq);                
            
        List<Integer> res = new ArrayList<>();
        for(int i = N; i >= 1; i--){
            List<Integer> elements = distributions[i];
            if(elements == null) continue;
            for(int e : elements){
                res.add(e);
                k--;
            }
            if (k == 0) break;
        }
        int[] array = new int[res.size()];
        for(int i = 0; i < res.size(); i++)
            array[i] = res.get(i);
        
        return array;
    }
}