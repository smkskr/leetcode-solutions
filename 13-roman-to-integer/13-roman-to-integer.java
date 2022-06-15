class Solution {
    public int romanToInt(String s) {
        
        Map<Character,Integer> romanToIntegerMap = new HashMap<>();
        romanToIntegerMap.put('I',1);
        romanToIntegerMap.put('V',5);
        romanToIntegerMap.put('X',10);
        romanToIntegerMap.put('L',50);
        romanToIntegerMap.put('C',100);
        romanToIntegerMap.put('D',500);
        romanToIntegerMap.put('M',1000);
        
        int index = s.length() - 1;
        int lastValue = romanToIntegerMap.get(s.charAt(index));
        index = index - 1;
        int total = lastValue;
        while(index >= 0){
            
            int currentValue = romanToIntegerMap.get(s.charAt(index--));
            if(currentValue >= lastValue){
                total += currentValue;
            }else{
                total -= currentValue;
            }
            lastValue = currentValue;
        }
        
        return total;
    }
}