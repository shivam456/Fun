class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root=new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char currentChar = word.charAt(i);
            if(node.links[currentChar-'a']==null){
                node.links[currentChar-'a']=new TrieNode();
         }
            node=node.links[currentChar-'a'];
        }
        node.isEnd=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char currentChar = word.charAt(i);
            if(node.links[currentChar-'a']==null){
                return false;
            }
            node=node.links[currentChar-'a'];
        }
        return node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char currentChar = word.charAt(i);
            if(node.links[currentChar-'a']==null){
                return false;
            }
            node=node.links[currentChar-'a'];
        }
        return true;
    }
}

class TrieNode{
    public boolean isEnd;
    public TrieNode[] links;
    
    public TrieNode(){
        links = new TrieNode[26];
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */