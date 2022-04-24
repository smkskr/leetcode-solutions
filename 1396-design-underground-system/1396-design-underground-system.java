class UndergroundSystem {
    
    Map<Integer, TripDetails> checkInMap;
    Map<String, TripCount> tripTimeMap;
    
    public UndergroundSystem() {
        
        checkInMap = new HashMap<>();
        tripTimeMap = new HashMap<>();
        
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new TripDetails(stationName,t));
    }
    
    public void checkOut(int id, String stationName, int t) {
      
        TripDetails sourceTrip = checkInMap.get(id);
        String source = sourceTrip.stationName;
        int time = sourceTrip.time;
        
        String key = source + "_" + stationName;
        
        if(tripTimeMap.containsKey(key)){
            TripCount obj = tripTimeMap.get(key);
            obj.totalTime += (t - time);
            obj.count++;
            tripTimeMap.put(key, obj);
        }
        else
        tripTimeMap.put(key, new TripCount(t - time, 1));

    }
    
    public double getAverageTime(String startStation, String endStation) {
        
        String key = startStation + "_" + endStation;
        TripCount obj = tripTimeMap.get(key);
        return (double)obj.totalTime/obj.count;
    }
}

class TripDetails{
    
    String stationName;
    int time;
    
    TripDetails(String _stationName, int _time){
        stationName = _stationName;
        time = _time;
    }
}

class TripCount{
    int totalTime;
    int count;
    
    TripCount(int _totalTime, int _count){
        totalTime = _totalTime;
        count = _count;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */

