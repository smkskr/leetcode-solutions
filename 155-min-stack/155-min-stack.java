class MinStack {
    
    Stack<Integer> stack;
    List<Integer> minValList;
    
    public MinStack() {
        
        stack = new Stack<>();
        minValList = new ArrayList<>();
        
    }
    
    public void push(int val) {
        
        stack.push(val);
        
        int len = minValList.size();
        if(len == 0)minValList.add(val);
        else if(minValList.get(len - 1) >= val){
            minValList.add(val);
        }
        
    }
    
    public void pop() {
        
        
        
      
            
            int val = stack.peek();
            
            stack.pop();
            
            int len = minValList.size();
            if(minValList.get(len - 1) == val)minValList.remove(len - 1);
            
       
       
        
    }
    
    public int top() {
            return stack.peek();
    }
    
    public int getMin() {
        
        int len = minValList.size();
        return minValList.get(len - 1);
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */