class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        
        int max = Integer.MIN_VALUE;
        
        PriorityQueue<Item> queue = new PriorityQueue<>();
        
        for(int i = 0; i < nums.size(); i++){
            List<Integer> list = nums.get(i);
            max = Math.max(max, list.get(0));
            queue.add(new Item(list.get(0), i, 0));            
        }
        
        int range = Integer.MAX_VALUE;
        int start = -1, end = -1;
        
        while(queue.size() == nums.size()){
            Item curr = queue.poll();
            if(max - curr.val < range){
                range = max - curr.val;
                start = curr.val;
                end = max;
            }
            
            List<Integer> list = nums.get(curr.list);
            if(curr.idx+1 < list.size()){
                curr.val = list.get(curr.idx+1);
                curr.idx += 1;
                queue.add(curr);
                max = Math.max(max, curr.val);
            }            
        }
        
        return new int[]{start, end};
    }
    
    private class Item implements Comparable<Item> {
        int val;
        int list;
        int idx;
        
        public Item(int val, int list, int idx){
            this.val = val;
            this.list = list;
            this.idx = idx;
        }
        
        @Override
        public int compareTo(Item o){
            return this.val - o.val;
        }        
    }
}