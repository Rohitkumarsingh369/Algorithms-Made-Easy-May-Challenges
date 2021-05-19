class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
         HashMap<String,List<String>> map = new HashMap<>();
        for(String path:paths)
        {
            String[] dir = path.split(" ");
            for(int i=1;i<dir.length;i++)
            {
                String[] content = dir[i].split("\\(");
                content[1] = content[1].replace(")","");
                List<String> list = map.getOrDefault(content[1],new ArrayList<String>());
                list.add(dir[0]+"/"+content[0]);
                map.put(content[1],list);
            }
            }
        List<List<String>> result = new ArrayList<>();
        for(String key:map.keySet()){
            if(map.get(key).size()>1)
                result.add(map.get(key));
        }
        return result;
        }
    
}