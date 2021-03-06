public class ZigzagIterator {
   
    Iterator<Integer> i, j, tmp;
    public ZigzagIterator(List<Integer> v0, List<Integer> v1) {
        i = v1.iterator();
        j = v0.iterator();
    }

    public int next() {
       if(j.hasNext()){
           tmp = j;
           j = i;
           i = tmp;
       }
        return i.next();
    }

    public boolean hasNext() {
        return i.hasNext() || j.hasNext();
    }
    
}



/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */