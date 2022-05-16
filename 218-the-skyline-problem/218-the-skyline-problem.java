class BuildingPoints implements Comparator<BuildingPoints>{
    
    int x;
    int height;
    boolean isStart;
    
    BuildingPoints(){}
    
    @Override
    public int compare(BuildingPoints a, BuildingPoints b){
            
        if(a.x != b.x){
            return a.x - b.x;
        }else{
            return (a.isStart ? -a.height : a.height) - (b.isStart ? -b.height : b.height);
        }
        
    }
}
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        
        List<List<Integer>> result = new ArrayList<>();
        int index = 0;
        BuildingPoints[] buildingPoints = new BuildingPoints[buildings.length*2];
        
        for(int[] building : buildings){
            buildingPoints[index] = new BuildingPoints();
            buildingPoints[index].x = building[0];
            buildingPoints[index].isStart = true;
            buildingPoints[index].height = building[2];
            
            buildingPoints[index+1] = new BuildingPoints();
            buildingPoints[index+1].x = building[1];
            buildingPoints[index+1].isStart = false;
            buildingPoints[index+1].height = building[2];
            index += 2;
        }
        
        Arrays.sort(buildingPoints, new BuildingPoints());
        
        TreeMap<Integer,Integer> queue = new TreeMap<>();
        queue.put(0,1);
        int prevMaxHeight = 0;
        
        for(BuildingPoints buildingPoint : buildingPoints){
            
            if(buildingPoint.isStart){
                queue.compute(buildingPoint.height, (key, value) -> {
                    if(value != null){
                        return value + 1;
                    }
                    return 1;
                });
            }else{
                queue.compute(buildingPoint.height, (key, value) -> {
                    if(value == 1){
                        return null;
                    }
                    return value - 1;
                });
            }
            
            int currentMaxHeight = queue.lastKey();
            
             if (prevMaxHeight != currentMaxHeight) {
                 List<Integer> temp = new ArrayList<>();
                 temp.add(buildingPoint.x);
                 temp.add(currentMaxHeight);
                 result.add(temp);
                 prevMaxHeight = currentMaxHeight;
            }
            
        }
        
        return result;
        
    }
}