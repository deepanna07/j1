import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WordProcessor {
    private static Log log = LogFactory.getLog(WordProcessor.class);
    public static void main(String[] args) {
        String option = args[0];
        WordCounter wordCounter = new WordCounter();
        FileReader fileReader = new FileReader();
        FileWriter fileWriter = new FileWriter();

        if(option.equals("-C")) {
            int wordCount = wordCounter.getWordCountFromConsole(args);
            String words = wordCounter.printWordMap(args);
            String distinctWordCount = wordCounter.distinctWordCount(args);
            log.info("word count:" + wordCount+"\n");
            log.info(words);
            log.info(distinctWordCount);
        } else if(option.equals("-F")) {
            String content = fileReader.readFileContent(args[1]);
            String[] contentArr = content.split(" ");
            int wordCount = wordCounter.getWordCountFromFile(contentArr);
            String words = wordCounter.printWordMap(contentArr);
            String distinctWordCount = wordCounter.distinctWordCount(contentArr);
            if(args.length>2 && args[2].equals("-outFile")) {
                String contentTobeWrite = "word count:" + wordCount+"\n"+words+distinctWordCount;
                fileWriter.writeToFile(contentTobeWrite,args[3]);
            } else {
                log.info("word count:" + wordCount+"\n");
                log.info(words);
                log.info(distinctWordCount);
            }
        }
    }
}
