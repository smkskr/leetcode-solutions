class IndexMap{
    
    char _element;
    int _index;
    public IndexMap(char element,int index){
        _element = element;
        _index = index;
    }
}
class Solution {
    public String minRemoveToMakeValid(String s) {
        
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
        int i = 0;
        int size = indexNotIncluded.size();
//         while(index < indexNotIncluded.size()){
//             if(i != indexNotIncluded.get(index)){
//                 result += s.charAt(i);
//             }else{
//                 index++;
//             }
//             i++;
//         }
        
//         while(i < len){
//             result += s.charAt(i);
//             i++;
//         }
        
        for(i = 0;i < size;i++){
            int limit = indexNotIncluded.get(i);
            result.append(s.substring(index,limit));
            index = limit + 1;
        }
        
        result.append(s.substring(index, len));
        return result.toString();
    }
}

