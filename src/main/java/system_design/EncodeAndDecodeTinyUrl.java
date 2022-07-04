package system_design;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

// Random fixed-length encoding
public class EncodeAndDecodeTinyUrl {

    String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    HashMap<String, String> map = new HashMap<>();
    Random rand = new Random();
    String key = getRand();

    private String getRand() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(alphabet.charAt(rand.nextInt(alphabet.length())));
        }
        return stringBuilder.toString();
    }

    //possible encodings - (10+26*2)^6
    private String encode(String url) {
        while (map.containsKey(key)) {
            key = getRand();
        }
        map.put(key, url);
        return "http://tinyurl.com/" + key;
    }

    private String decode(String tinyUrl) {
        return map.get(tinyUrl.replace("http://tinyurl.com/", ""));
    }


    public static void main(String[] args) {
        String[] urls = new String[]{"www.google.com", "https://leetcode.com/problems/design-tinyurl", "https://leetcode.com/problems/encode-and-decode-tinyurl/solution/"};
        EncodeAndDecodeTinyUrl encodeAndDecodeTinyUrl = new EncodeAndDecodeTinyUrl();

        for (String url : urls) {
            final String encodeValue = encodeAndDecodeTinyUrl.encode(url);
            System.out.println("encodeValue " + encodeValue);
            System.out.println("decodeValue " + encodeAndDecodeTinyUrl.decode(encodeValue));
            System.out.println("-------\n");
        }

        for (Map.Entry<String, String> entries : encodeAndDecodeTinyUrl.map.entrySet()) {
            System.out.println(entries.getKey() + " " + entries.getValue());
        }


    }
}
