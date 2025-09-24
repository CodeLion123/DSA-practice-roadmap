class TrieNode {
    Map<Character, TrieNode> trieMap;
    boolean isWordEnd;

    public TrieNode() {
        trieMap = new HashMap<>();
        isWordEnd = false;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    /**
     * Time: O(m)
     * Space: O(m)
     * where m is the length of the word
     * Approach: Trie
     * @param word The word to be inserted into the trie
     * @return void
     */
    public void insert(String word) {
        TrieNode node = this.root;
        for(char ch: word.toCharArray()){
            node.trieMap.putIfAbsent(ch, new TrieNode());
            node = node.trieMap.get(ch);
        }
        node.isWordEnd = true;
    }

    /**
     * Time: O(m)
     * Space: O(m)
     * where m is the length of the word
     * Approach: Trie
     * @param word The word to be searched in the trie
     * @return true if the word exists in the trie, false otherwise
     */
    public boolean search(String word) {
        TrieNode node = root;
        for(char ch: word.toCharArray()){
            if (!node.trieMap.containsKey(ch)) return false;
            
            node = node.trieMap.get(ch);
        }
        return node.isWordEnd;
    }
    
    /**
     * Time: O(m)
     * Space: O(m)
     * where m is the length of the prefix
     * Approach: Trie
     * @param prefix The prefix to be searched in the trie
     * @return true if there is a word in the trie that starts with the given prefix, false otherwise
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        int i=0;
        for(char ch: prefix.toCharArray()){
            if (!node.trieMap.containsKey(ch)) break;
            
            node = node.trieMap.get(ch);
            i++;
        }
        if (i == prefix.length()) return true;
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */