import java.util.*;

public class StringMapLC127 {

    Map<String, Set<String>> stringMap = new HashMap<>();


    private void prepareStringMap(String beginWord, List<String> wordList) {

        ListIterator<String> wordListIteratror = wordList.listIterator();
        while (wordListIteratror.hasNext()) {

            String word = wordListIteratror.next();
            if (beginWord.length() == word.length() && numberOfDifferentChars(beginWord, word) == 1) {

                if (stringMap.containsKey(beginWord)) {
                    stringMap.get(beginWord).add(word);
                } else {
                    Set<String> words = new HashSet<>();
                    words.add(word);
                    stringMap.put(beginWord, words);
                }

                List<String> wordListCopy = new ArrayList<>(wordList);
                wordListCopy.remove(word);
                prepareStringMap(word, wordListCopy);
            }
            wordListIteratror.remove();

        }
    }

    private int numberOfDifferentChars(String beginWord, String word) {
        final int length = word.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (beginWord.charAt(i) != word.charAt(i))
                count += 1;
        }

        return count;
    }

    public static void main(String[] args) {
        StringMapLC127 stringMapLC127 = new StringMapLC127();

        List<String> words = new ArrayList<>();
        words.add("hot");
        words.add("dot");
        words.add("dog");
        words.add("lot");
        words.add("log");
        words.add("cog");
        stringMapLC127.prepareStringMap("hit", words);

        System.out.println(stringMapLC127.stringMap);
    }
}
