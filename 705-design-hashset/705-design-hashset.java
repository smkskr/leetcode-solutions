class MyHashSet {
    
    int[] arr;
    int size = 10000001;
    public MyHashSet() {
        arr = new int[size];
        Arrays.fill(arr, -1);
    }
    
    public void add(int key) {
        arr[key] = key;
    }
    
    public void remove(int key) {
        arr[key] = -1;
    }
    
    public boolean contains(int key) {
        return arr[key] == key;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */