class AutocompleteSystem {

Trie root;
Trie curr;
String prefix = "";
boolean flag = false;
public AutocompleteSystem(String[] sentences, int[] times) {
    root = new Trie();
    curr = root;
    for (int i = 0; i < sentences.length; i++)
    {
        add(root, sentences[i], times[i]);
    }
}

public List<String> input(char c) {
    List<String> output = new ArrayList<>();
    if (c == '#')
    {
        add(root, prefix, 1);
        prefix = "";
        curr = root;
        flag = false;
        return output;
    }
    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.c == b.c ? a.s.compareTo(b.s) : b.c - a.c));
    prefix += c;
    if(curr.neighbors.containsKey(c) && flag == false)
    {
        curr = curr.neighbors.get(c);
        for (String s : curr.map.keySet()) 
        {
            pq.add(new Pair(s, curr.map.get(s)));
        }
        for (int i = 0; i < 3 && !pq.isEmpty(); i++)
        {
            output.add(pq.poll().s);        
        }
    }
    else {
        flag = true;
    }
    return output;
    
}

private void add(Trie root, String word, int times)
{
    Trie curr = root;
    for (int index = 0; index < word.length(); index++)
    {
        
        if (!curr.neighbors.containsKey(word.charAt(index)))
            curr.neighbors.put(word.charAt(index), new Trie());
         
        curr = curr.neighbors.get(word.charAt(index));
        
        if (curr.map.containsKey(word))
            curr.map.put(word, curr.map.get(word) + times);
        else curr.map.put(word, times);
        
    }
}

private class Pair {
    String s;
    int c;
    Pair(String s, int c)
    {
        this.s = s;
        this.c = c;
    }
}

private class Trie {
    HashMap<String, Integer> map;
    HashMap<Character, Trie> neighbors;

    public Trie()
    {
        map = new HashMap<>();
        neighbors = new HashMap<>();
    }
    
}
}