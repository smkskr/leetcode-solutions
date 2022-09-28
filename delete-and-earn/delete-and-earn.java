class Solution {
     
    HashMap<Integer, Integer> points = new HashMap<>();

    public int deleteAndEarn(int[] nums) {
       
        int maxNumber = 0;
        
        for(int num : nums){
           points.put(num, points.getOrDefault(num, 0) + num);
           maxNumber = Math.max(maxNumber, num);
        }
        
        return maxPoints(maxNumber);
    }
    
    public int maxPoints(int maxNumber){
        
       // int[] maxPoints = new int[maxNumber + 1];
        if(maxNumber == 0)return 0;
        
        if(maxNumber == 1)return points.getOrDefault(1,0);
        
        
        int maxPoints = 0;
        int twoBack = 0;
        int oneBack = points.getOrDefault(1,0);
        
        for(int index = 2;index <= maxNumber;index++){
            int gain = points.getOrDefault(index, 0);
            maxPoints = Math.max(oneBack, twoBack + gain);
            twoBack = oneBack;
            oneBack = maxPoints;
        }
        
        return maxPoints;
    }
}