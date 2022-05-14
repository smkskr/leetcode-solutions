// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class DoubleListNode{
    
    char ch;
    DoubleListNode next;
    DoubleListNode prev;
    
    DoubleListNode(char _ch){
        ch = _ch;
        next = null;
        prev = null;
    }
    
}
class Solution
{   
    HashMap<Character, DoubleListNode> dlMap = new HashMap<>();
    // List<Character> dLL = new ArrayList<>();
    //HashMap<Character, Boolean> repeatMap = new HashMap<>();
    boolean[] repeatMap = new boolean[26];
    DoubleListNode head = null;
    DoubleListNode tail = null;
    
    public String FirstNonRepeating(String A)
    {   
        String res = "";
        // code here
        int len = A.length();
        for(int i = 0;i < len;i++){
            char ch = A.charAt(i);
            //if repeatMap contains character
            if(repeatMap[ch - 'a'] == false){
                if(dlMap.containsKey(ch)){
                    DoubleListNode node = dlMap.get(ch);
                    removeFromList(node);
                    repeatMap[ch - 'a'] = true;
                }else{
                    DoubleListNode node = new DoubleListNode(ch);
                    addToList(node);
                    dlMap.put(ch, node);
                }
            }else{
                res += head == null ?  "#" : head.ch;continue;
            }
            
             res += head == null ?  "#" : head.ch;
            
        }
        
        return res;
    }
    
    public void removeFromList(DoubleListNode node){
        if(node.prev != null){
            node.prev.next = node.next;
        }else{
            head = node.next;
        }
        
        if(node.next != null){
            node.next.prev = node.prev;
        }else{
            tail = node.prev;
        }
    }
    
    public void addToList(DoubleListNode node){
        
        if(head == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }
    
}
