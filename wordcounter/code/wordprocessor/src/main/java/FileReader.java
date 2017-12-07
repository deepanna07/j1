import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {
    private static Log log = LogFactory.getLog(FileReader.class);
    BufferedReader br = null;
    FileReader fr = null;

    public String readFileContent(String fileName) {

        String line = null;
        String content = "";

        try {
            java.io.FileReader fileReader =
                    new java.io.FileReader(fileName);
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                content+=line;
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            log.error("Unable to open file '" +
                    fileName + "'");
        }
        catch(IOException ex) {
            log.error("Error reading file '"
                    + fileName + "'");
        }
        return content;
    }
}
