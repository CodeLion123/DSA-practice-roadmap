class Solution {
    List<String> res = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) trie.insert(word);

        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dfs(board, visited, i, j, trie.root, new StringBuilder());

        return res;
    }

    private void dfs(char[][] board, boolean[][] visited, int i, int j, TrieNode node, StringBuilder sb) {
        int m = board.length, n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) return;
        char c = board[i][j];
        if (!node.trieMap.containsKey(c)) return;

        visited[i][j] = true;
        sb.append(c);
        TrieNode nextNode = node.trieMap.get(c);

        if (nextNode.isWordEnd) {
            res.add(sb.toString());
            nextNode.isWordEnd = false;
        }

        dfs(board, visited, i + 1, j, nextNode, sb);
        dfs(board, visited, i - 1, j, nextNode, sb);
        dfs(board, visited, i, j + 1, nextNode, sb);
        dfs(board, visited, i, j - 1, nextNode, sb);

        visited[i][j] = false;
        sb.deleteCharAt(sb.length() - 1);
    }
}

class TrieNode {
    Map<Character, TrieNode> trieMap = new HashMap<>();
    boolean isWordEnd = false;
}

class Trie {
    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.trieMap.putIfAbsent(ch, new TrieNode());
            node = node.trieMap.get(ch);
        }
        node.isWordEnd = true;
    }
}
