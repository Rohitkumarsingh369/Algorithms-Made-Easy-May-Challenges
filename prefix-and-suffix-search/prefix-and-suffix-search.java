class WordFilter {
    Trie prefix=null;
        Trie suffix=null;
    public WordFilter(String[] words) {
        prefix=new Trie();
        suffix=new Trie();
        for(int i=0;i<words.length;i++){
            prefix.insert(words[i],i);
            suffix.insert(new StringBuilder(words[i]).reverse().toString(),i);
        }
    }
    
    public int f(String pre, String suff) {
        List<Integer> plist=prefix.startswith(pre);
        List<Integer> slist=suffix.startswith(new StringBuilder(suff).reverse().toString());
        
            int i=plist.size()-1,j=slist.size()-1;
        
        while(i>=0 && j>=0){
            if(Objects.equals(plist.get(i),slist.get(j)))
                return plist.get(i);
            else if(plist.get(i)>slist.get(j))
                i--;
            else
                j--;
        }
        return -1;
    }
}
class Trie{
    public Trie[]t;
    List<Integer> index;
    Trie(){
        t=new Trie[26];
        index=new ArrayList<>();
    }
    //insert
    public void insert(String word,int i){
        Trie root=this; //current instance of trie
        for(char c:word.toCharArray()){
            if(root.t[c-'a']==null){
                root.t[c-'a']=new Trie();
            }
            root=root.t[c-'a'];
            root.index.add(i);
        }
    }
    //startwith
    public List<Integer> startswith(String word){
        Trie root=this;
        for(char c:word.toCharArray()){
            if(root.t[c-'a']==null){
                return new ArrayList<>();
            }
            root=root.t[c-'a'];
            
        }
        return root.index;
    }
    
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */