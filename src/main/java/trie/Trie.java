package trie;

public class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                final char c = word.charAt(i);
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode tempRoot = root;
            for (char letter : word.toCharArray()) {
                if (tempRoot.children[letter - 'a'] == null)
                    return false;
                tempRoot = tempRoot.children[letter - 'a'];
            }
            return tempRoot.isEnd;
        }

        public boolean startsWith(String prefix) {
            TrieNode tempRoot = root;
            for (char letter : prefix.toCharArray()) {
                if (tempRoot.children[letter - 'a'] == null)
                    return false;
                tempRoot = tempRoot.children[letter - 'a'];
            }

            return true;
        }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("foo");
        System.out.println("search " + trie.search("f"));
        System.out.println("startsWith " + trie.startsWith("f"));
    }
}