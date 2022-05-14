/**
* create a doubly linked list 
* DLL acts as a queue -> which has Most Recently Used Item at front and Least Recently Used Item at the last
* DLL is used for moving the values around the queue in case of hit/miss in O(1) time
* 
* For fetching the item we are going to use HashMap which stores the reference of the DLL
* HashMap is used for fetching and storing the item in O(1) time
*
*/
class DoubleListNode{
    
    int key;
    int value;
    DoubleListNode prev;
    DoubleListNode next;
    
    DoubleListNode(int _key,int _value){
        key = _key;
        value = _value;
        prev = null;
        next = null;
    }
    
}
class LRUCache {
    
    int capacity;
    HashMap<Integer, DoubleListNode> map = new HashMap<>();
    DoubleListNode head = null;
    DoubleListNode tail = null;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        
        if(map.containsKey(key)){
            //hit
            DoubleListNode node = map.get(key);
            remove(node);
            setHead(node);
            return node.value;
        }
       
            //miss
            return -1;   
        
        
    }
    
    public void put(int key, int value) {
       
        if(map.containsKey(key)){
            //if map already has the key..then we need to move this key at the start of the DLL,
            //since it becomes Most Recently Used
            DoubleListNode node = map.get(key);
            node.value = value;
            remove(node);
            setHead(node);
            
        }
        else {
            DoubleListNode newNode = new DoubleListNode(key,value);
            if(map.size() == capacity){
                map.remove(tail.key);
                remove(tail);
               
            }
            setHead(newNode);
            map.put(key, newNode);
        }
        
    }
    
    public void remove(DoubleListNode node){
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
        // if(node == tail){
        //     node.prev.next = node.next;
        //     tail = node.prev;
        // }
        // else if(node == head){
        //     head = node.next;
        //     head.prev = null;
        //     node.next = null;
        // }else{
        //      node.prev.next = node.next;
        //      node.next.prev = node.prev;
        // }
       
    }
    
    public void setHead(DoubleListNode newNode){
        //if head is null
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            newNode.prev = null;
            head.prev = newNode;
            head = newNode;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */