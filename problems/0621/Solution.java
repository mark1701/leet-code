class Solution {
    
    PriorityQueue<CPUTask> pq;
    
    public int leastInterval(char[] tasks, int n) {
            
        int[] tasksCount = countTasks(tasks);
        
        pq = new PriorityQueue<>();
        loadTasks(tasksCount, pq);
        
        List<CPUTask> lastUsed = new ArrayList<>();

        int count = 0;
        while (!pq.isEmpty()) {
            int k = n + 1;
            lastUsed.clear();
            
            while (k > 0 && pq.size() > 0) {
                CPUTask top = pq.poll();
                top.count--;
                lastUsed.add(top); 
                k--;
                count++;
            }

            for (CPUTask ct : lastUsed)
                if (ct.count > 0) pq.add(ct);

            if (pq.size() == 0) break;
            count = count + k;
        }
        return count;
    }
    
    private void loadTasks(int[] tasksCount, PriorityQueue<CPUTask> pq){
        for(int i = 0; i < tasksCount.length; i++){
            if(tasksCount[i] == 0) continue;
            CPUTask t = new CPUTask((char) (i + 'A'), tasksCount[i]);
            pq.add(t);
        }
    }
    
    private int[] countTasks(char[] tasks){
        int[] counts = new int[26];
        for(char c : tasks){
            counts[c - 'A']++;
        }
        return counts;
    }
}

class CPUTask implements Comparable<CPUTask>{
    int count;
    char id;
    public CPUTask(char id, int count){
        this.id = id;
        this.count = count;
    }
    
    public int compareTo(CPUTask that){
        return that.count - this.count;
    }
}