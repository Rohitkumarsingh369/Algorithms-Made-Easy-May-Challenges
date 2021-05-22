class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        char[] patternDecoded = decodeWord(pattern);
    
    List<String> res = new ArrayList();
    
    for (String w : words) {
        char[] wordDecoded = decodeWord(w);
        boolean match = true;
        for (int i = 0; i < wordDecoded.length; i++) {
            if (wordDecoded[i] != patternDecoded[i]) {
                match = false;
                break;
            }
        }
        if (match) {
            res.add(w);
        }
    }
    
    return res;
}

char[] decodeWord(String s) {
    char cur = 'a';
    char[] map = new char[26];
    for (char ch : s.toCharArray()) {
        if (map[ch - 'a'] == 0) {
            map[ch - 'a'] = cur;    
            cur++;
        }
    }
    
    char[] res = new char[s.length()];
    for (int i = 0; i < s.length(); i++) {
        res[i] = map[s.charAt(i) - 'a'];
    }
    return res;
    }
}