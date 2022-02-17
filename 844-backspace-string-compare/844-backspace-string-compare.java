class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        String one = backspaceProcess(s, s.length());
        String two = backspaceProcess(t, t.length());
        
        return one.compareTo(two) == 0;
        
    }
    
    public String backspaceProcess(String s, int len){
        
        Deque<Character> deque = new LinkedList<>();
        String result = "";
        for(int i = 0;i < len;i++){
            
           char ch = s.charAt(i);
           if(ch == '#'){
               if(!deque.isEmpty())deque.pollLast();
           }else{
               deque.addLast(ch);
           }
            
        }
        
        while(!deque.isEmpty()){
            result = result + deque.pollFirst();
        }
        
        return result;
    }
    
}