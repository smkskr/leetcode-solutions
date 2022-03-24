class Solution {
    public double average(int[] salary) {
        
        Arrays.sort(salary);
        int len = salary.length - 1;
        double sum = 0.0;
        for(int index = 1;index < len;index++){
            sum += salary[index];
        }
        
        return sum/(len - 1);
    }
} 