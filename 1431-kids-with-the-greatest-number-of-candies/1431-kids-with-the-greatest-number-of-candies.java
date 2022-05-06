class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        List<Boolean> result = new ArrayList<>();
        int max = findMax(candies);
        for(int candy : candies){
            if(candy + extraCandies >= max){
                result.add(true);
            }else result.add(false);
        }
        
        return result;
    }
    
    //find max candies
    public int findMax(int[] candies){
        
        int max = Integer.MIN_VALUE;
        
        for(int candy : candies){
            max = Math.max(max, candy);
        }
        
        return max;
    }
}