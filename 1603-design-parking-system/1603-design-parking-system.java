class ParkingSystem {
    
   int[] carSlots = new int[4];
    
    public ParkingSystem(int big, int medium, int small) {
        
        carSlots[1] = big;
        carSlots[2] = medium;
        carSlots[3] = small;
        
    }
    
    public boolean addCar(int carType) {
        
        if(carSlots[carType] > 0){
            carSlots[carType]--;
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */