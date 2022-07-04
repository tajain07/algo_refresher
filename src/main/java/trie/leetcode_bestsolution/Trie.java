package trie.leetcode_bestsolution;

import java.util.HashMap;

public class Trie {

    static class TrieNode {
        TrieNode parent;
        char v;
        HashMap<Character, TrieNode> children = new HashMap<>();
        String word = null;

        public TrieNode getOrCreateChild(Character c) {
            var it = children.get(c);
            if (it == null) {
                it = new TrieNode();
                it.v = c;
                it.parent = this;
                children.put(c, it);
            }
            return it;
        }
    }


    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public Trie(TrieNode root) {
        this.root = root;
    }

    public void addWord(String word) {
        var node = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            char c = word.charAt(i);
            var next = node.getOrCreateChild(c);
            next.parent = node;
            node = next;
        }
        node.word = word;
    }

    public void removeWord(TrieNode node) {
        node.word = null;

        while (node.word == null && node.parent != null && node.children.isEmpty()) {
            node.parent.children.remove(node.v);
            node = node.parent;
        }
    }

    public static void main(String[] args) {
        TrieNode trieRoot = new TrieNode();
        Trie trie = new Trie(trieRoot);
        trie.addWord("hello");
        trie.addWord("hxllo");
        trie.addWord("hexlo");

        TrieNode node = trieRoot;
        String word = "hello";
        for (int i = 0; i < word.length(); i++) {
            final char c = word.charAt(i);
            node = node.children.get(c);
        }

        trie.removeWord(node);
    }

}