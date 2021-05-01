class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer,Integer> map=new HashMap<>(); // key:xcoordinate value:count
        int untouched=0;
        
        for(List<Integer> row:wall){
            int end=0;
            for(int brick=0;brick<row.size()-1;brick++){
                end+=row.get(brick);
                map.put(end,map.getOrDefault(end,0)+1);
                untouched=Math.max(untouched,map.get(end));
            }
        }
        return wall.size()-untouched;
    }
}