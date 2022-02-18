class Solution {
    public int[] finalPrices(int[] prices) {
        
        int n = prices.length;
         Stack<Integer> stack = new Stack<>();//storing indexes of array element
        int[] result = new int[n];
        stack.push(0);
        for(int i = 1;i < n;i++){
            
            //popping out element whenever there is any value less than or equal to the top element of the stack
            while(!stack.isEmpty() && prices[i] <= prices[stack.peek()]){
                int val = stack.pop();
                result[val] = prices[val] - prices[i];
            }
            stack.push(i);
        }
        
        //if the stack is not empty then the remaining values have no smaller element than itself
        while(!stack.isEmpty()){
            int val = stack.pop();
            result[val] = prices[val];
        }
 
        return result;
    }
}