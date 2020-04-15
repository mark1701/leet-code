import java.util.NoSuchElementException;
class PeekingIterator implements Iterator<Integer> {
    
    Iterator<Integer> iterator;
    int current;
    boolean end = false;
	public PeekingIterator(Iterator<Integer> iterator) {
	    
        this.iterator = iterator;
        if(iterator.hasNext()){
            current = iterator.next();
        }else
            end = true;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return current;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if(end) throw new NoSuchElementException();
        int res = current;
        if(iterator.hasNext()){
            current = iterator.next();
        }else
            end = true;
        return res;
	}
	
	@Override
	public boolean hasNext() {
	    return !end;
	}
}