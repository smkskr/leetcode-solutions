class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder result = new StringBuilder(s);
        Stack<Integer> stack = new Stack();
        
        int len = s.length();
        for(int i = 0;i < len;i++){
            
            char ch = s.charAt(i);
            if(ch == '(')stack.add(i);
            else if(ch == ')'){
                
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    result.setCharAt(i,'*');
                }
            }
        }
        
        while(!stack.isEmpty()){
            result.setCharAt(stack.pop(), '*');
        }
        
        return result.toString().replaceAll("\\*","");
    }
    
    //return usingStackAsIndexMap(s);
    
    public String usingStackAsIndexMap(String s) {
        
        Stack<IndexMap> stack = new Stack<>();
        List<Integer> indexNotIncluded = new ArrayList<>();
        
        int len = s.length();
        
        for(int i = 0;i < len;i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(new IndexMap(ch,i));
            }
            else if(ch == ')'){
                
                if(!stack.isEmpty()){
                     
                    IndexMap obj = stack.peek();
                    
                    char currCh = obj._element;
                    
                    if(currCh == '(')stack.pop();
                    else{
                        indexNotIncluded.add(i);
                    }
                        
                }else{
                    indexNotIncluded.add(i);            
                }
               
            }
        }
        
        Iterator<IndexMap> value = stack.iterator();
        while(value.hasNext()){
            IndexMap obj = value.next();
            indexNotIncluded.add(obj._index);
        }
        
        StringBuffer result = new StringBuffer();
        int index = 0;
        int size = indexNotIncluded.size();

        
        for(int i = 0;i < size;i++){
            int limit = indexNotIncluded.get(i);
            result.append(s.substring(index,limit));
            index = limit + 1;
        }
        
        result.append(s.substring(index, len));
        return result.toString();
    }



}

class IndexMap{
    
    char _element;
    int _index;
    public IndexMap(char element,int index){
        _element = element;
        _index = index;
    }
}

    