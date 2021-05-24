class Solution {
    public String shortestSuperstring(String[] words) {
        if (words.length == 1) {
		return words[0];
		}
        int l = words.length;
        String[][] memo = new String[l][l];
        Map<Integer, String[]> map = new HashMap<>();
        for (int j =0;j<l;j++) {
            for (int k=0;k<l;k++) {
                if (j==k) {continue;}
                memo[j][k] = getSuffix(words[j], words[k]);
                if (!map.containsKey((1<<j)|(1<<k))) {
                    map.put((1<<j)|(1<<k), new String[l]);
                }
                String[] arr = map.get((1<<j)|(1<<k));
                arr[k] = words[j] + memo[j][k];
            }
        }
        for (int n=3;n<=l;n++) {
            Map<Integer, String[]> next = new HashMap<>();
            for (int key:map.keySet()) {
                String[] arr= map.get(key);
                for (int j=0;j<l;j++) {
                    if (arr[j] == null) {continue;}
                    for (int k=0;k<l;k++) {
                        if ((key & (1<<k)) != 0) {continue;}
                        if (!next.containsKey(key | (1<<k))) {
                            next.put(key|(1<<k), new String[l]);
                        }
                        String[] arr2 = next.get(key|(1<<k));
                        if (arr2[k] == null || arr2[k].length() > arr[j].length() + memo[j][k].length()) {
                            arr2[k] = arr[j] + memo[j][k];
                        }
                    }
                }
            }
            map = next;
        }
        String res = null;
        for (String s:map.get((1<<l)-1)) {
            if (res==null || res.length() > s.length()) {res=s;}
            
        }
        return res;
    }   
    private String getSuffix(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        for (int j=Math.max(0, l1-l2);j<l1;j++) {
            if (s1.substring(j).contentEquals(s2.substring(0, l1-j))) {
                return s2.substring(l1-j);
            }
        }
        return s2;
    }
}