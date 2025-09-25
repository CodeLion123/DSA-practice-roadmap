class TrieNode {
    Map<Character, TrieNode> trieMap;
    boolean isWordEnd;

    public TrieNode() {
        trieMap = new HashMap<>();
        isWordEnd = false;
    }
}

class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = this.root;
        for(char ch: word.toCharArray()){
            node.trieMap.putIfAbsent(ch, new TrieNode());
            node = node.trieMap.get(ch);
        }
        node.isWordEnd = true;
    }
    
    public boolean search(String word) {
        return checkSearchDot(this.root, word, 0);
    }
    private boolean checkSearchDot(TrieNode root, String word, int pos) {
        TrieNode tempNode = root;
        for (int i=pos; i<word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (Map.Entry<Character, TrieNode> entry : tempNode.trieMap.entrySet()) {
                    TrieNode next = entry.getValue();
                    if (checkSearchDot(next, word, i+1)) return true; 
                }
                return false;
            } else {
                if (!tempNode.trieMap.containsKey(ch)) return false;
                tempNode = tempNode.trieMap.get(ch);
            }
        }
        return tempNode.isWordEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */