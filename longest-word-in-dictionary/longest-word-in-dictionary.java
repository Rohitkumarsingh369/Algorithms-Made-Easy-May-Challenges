class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        String result = "";
        HashSet<String> builtWords = new HashSet();
        for(String w : words) {
            if(w.length() == 1 || builtWords.contains(w.substring(0, w.length()-1))) {
                if(w.length() > result.length()) result = w;
                builtWords.add(w);
            }
        }
        return result;
    }
}