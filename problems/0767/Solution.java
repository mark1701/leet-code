class Solution {
    public String reorganizeString(String s) {
        
        int N = s.length();
        int[] count = new int[26];
        
        for(int i = 0; i < N; i++)
            count[s.charAt(i) - 'a']++;
        
        PriorityQueue<Item> items = new PriorityQueue<>();
        
        for(int i = 0; i < 26; i++)
            if(count[i] > 0) items.add(new Item(i+'a',count[i]));
        
        StringBuilder sb = new StringBuilder();
        while(sb.length() < N){
            
            if(items.isEmpty()) return "";
            
            Item first = items.poll();
            sb.append((char) first.id);
            first.count--;
            
            if(sb.length() == N) break;
            
            if(items.isEmpty()) return "";               
            
            Item second = items.poll();
            sb.append((char) second.id);
            second.count--;
            
            if(first.count > 0) items.add(first);
            if(second.count > 0) items.add(second);
        }
        
        return sb.toString();        
    }
    
    private class Item implements Comparable<Item>{
        int count;
        int id;
        public Item(int id, int count){
            this.id = id;
            this.count = count;
        }
        
        public int compareTo(Item that){
            if(this.count != that.count)
                return that.count - this.count;
            else
                return this.id - that.id;
        }
    }
}