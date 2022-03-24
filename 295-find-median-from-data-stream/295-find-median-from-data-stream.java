class MedianFinder {
    
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    
    public MedianFinder() {
        minHeap = new PriorityQueue();
        maxHeap = new PriorityQueue(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        
        if(maxHeap.isEmpty() || num < maxHeap.peek())maxHeap.offer(num);
        else{
            minHeap.offer(num);
        }
        
        if(maxHeap.size() - minHeap.size() == 2){
            balanceHeaps(maxHeap, minHeap);
        }else if(minHeap.size() - maxHeap.size() == 2){
            balanceHeaps(minHeap, maxHeap);
        }
        
    }
    
    public double findMedian() {
        
        int size = maxHeap.size() + minHeap.size();
        
        if(size % 2 == 0){
            return (double)(maxHeap.peek() + minHeap.peek())/2;
        }else{
            if(maxHeap.size() > minHeap.size()){
                return maxHeap.peek();
            }else{
                return minHeap.peek();
            }
        }
        
    }
    
    public void balanceHeaps(PriorityQueue<Integer> largerHeap, PriorityQueue<Integer> smallerHeap){
        int element = largerHeap.poll();
        smallerHeap.offer(element);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */