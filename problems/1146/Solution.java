class SnapshotArray {

    int id;
    Map<Integer, Integer> items;
    Map<Integer, Map<Integer, Integer>> archive;
    public SnapshotArray(int length) {
        id = 0; 
        items = new HashMap<>();
        archive = new HashMap<>();
    }
    
    public void set(int index, int val) {
        items.put(index, val);
    }
    
    public int snap() {
        archive.put(id++, items);
        Map<Integer,Integer> snap = new HashMap<>();
        for(int key : items.keySet()){
            int val = items.get(key);
            snap.put(key, val);
        }
        items = snap;
        return id - 1;
    }
    
    public int get(int index, int snap_id) {
        Map<Integer,Integer> snap = archive.get(snap_id);
        Integer val = snap.get(index);
        return val != null ? val : 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */