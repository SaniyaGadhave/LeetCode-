import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static String[] uncommonFromSentences(String s1, String s2) {
        
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");
        
      
        Map<String, Integer> wordCount = new HashMap<>();
        
       
        for (String word : words1) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
       
        for (String word : words2) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
       
        List<String> result = new ArrayList<>();
        
       
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        
        
        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String s1 = "apple banana cherry";
        String s2 = "banana orange apple";

        String[] uncommonWords = uncommonFromSentences(s1, s2);
        for (String word : uncommonWords) {
            System.out.println(word);
        }
    }
}
