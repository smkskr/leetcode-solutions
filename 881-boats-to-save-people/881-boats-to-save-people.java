/**
*
* This question can be treated similar to find pairs which sum up to a target
*
*/
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        int len = people.length;
        Arrays.sort(people);
        int count = 0;
        int start = 0;
        int end = len - 1;
        
        while(start <= end){
            count++;
            if(people[start] + people[end] <= limit){
                start++;
            }
            end--;
            
        }
        
        return count;
       
    }
        
    
   
}