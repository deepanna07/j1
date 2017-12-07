import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    private static Log log = LogFactory.getLog(WordCounter.class);

    public int getWordCountFromConsole(String[] wordArr) {
        return wordArr.length-1;
    }

    public int getWordCountFromFile(String[] wordArr) {
        return wordArr.length;
    }

    public String printWordMap(String[] wordArr) {
        Map<String, Integer> wordMap = getWordMap(wordArr);
        String content = "";
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            String key = entry.getKey().toString();
            Integer value = entry.getValue();
            content+= "word:" + key + " count:" + value+"\n";
        }
        return content;
    }

    public String distinctWordCount(String[] wordArr) {
        Map<String, Integer> wordMap = getWordMap(wordArr);
        String content = "Number of distinct words: " + wordMap.size();
        return content;
    }

    private Map<String, Integer> getWordMap(String[] wordArr) {
        Map<String, Integer> wordMap = new HashMap<String, Integer>();

        for (int i = 1; i < wordArr.length; i++) {
            String word = wordArr[i].toLowerCase();
            if(!wordMap.containsKey(word)) {
                wordMap.put(word, 1);
            } else {
                Integer value = wordMap.get(word);
                wordMap.put(word,new Integer(value+1));
            }
        }
        return wordMap;
    }
}
