class MapSum {
    TrieNode root;

    /** Initialize your data structure here. */
    public MapSum() {
        root=new TrieNode();
    }
    
    public void insert(String key, int value) {
        TrieNode node = root;
        for(int i=0;i<key.length();i++){
        
            if(node.links.containsKey(key.charAt(i))){
                
            }else{
                node.links.put(key.charAt(i),new TrieNode());
            }
            node=node.links.get(key.charAt(i));
        }
        node.val=value;
    }
    
    public int sum(String prefix) {
        int summ=0;
        TrieNode node = root;
        int i;
        for( i=0;i<prefix.length();i++){
            if(node==null){
                return 0;
            }
            node=node.links.get(prefix.charAt(i));
        }
        Queue<TrieNode> Q = new LinkedList<>();
        Q.add(node);
        while(!Q.isEmpty()){
            TrieNode temp = Q.poll();
            if(temp!=null){
            summ+=temp.val;
            for(TrieNode trie:temp.links.values()){
                Q.add(trie);
            }}
        }
    return summ; 
        }
}

class TrieNode{
    Map<Character,TrieNode> links = new HashMap<>();
    int val=0;
    
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */