// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    
    int index = 0;
    ArrayList<Integer> list = new ArrayList<>();
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    while (iterator.hasNext()) {
            list.add(iterator.next());
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return list.get(index);
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int val = list.get(index++);
        return val;
	}
	
	@Override
	public boolean hasNext() {
	    return index < list.size();
	}
}