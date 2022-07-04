package graph;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {

        String S = "catsanddog";
        String[] wordDict = new String[]{"cats", "dog", "sand", "and", "cat"};


        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak(S, List.of(wordDict)));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start])
                continue;

            //for substring(start, end) => substring will consider
            //elements from start-end-1
            for (int end = start + 1; end <= s.length(); end++) {
                if (wordDictSet.contains(s.substring(start, end))) {
                    queue.add(end);
                    if (end == s.length())
                        return true;
                }
                visited[start] = true;
            }
        }
        return false;
    }

}
