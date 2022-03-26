class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        // Sort the array in order of the difference in cost of A with cost of B -> (i.e costA - costB)
        // the first half of the array belongs to A and the next half to B
        // because the the greater the difference between them the lower the cost of B
        // hence the smaller difference value will be at first and therefore lower cost of A
        Arrays.sort(costs, (arr1, arr2) -> Integer.compare(arr1[0] - arr1[1], arr2[0] - arr2[1]));
        
        int sum = 0;
        int len = costs.length;
        
        for(int i = 0;i < len;i++){
            if(i < len/2){
                sum += costs[i][0];
            }else{
                sum += costs[i][1];
            }
        }
        
        return sum;
    }
}