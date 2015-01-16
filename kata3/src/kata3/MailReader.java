import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MailReader {
    
    private final String filePath;

    public MailReader(String filePath) {
        this.filePath = filePath;
    }
    
    public String[] readDomains() {
        ArrayList<String> domainList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            while(true) {
                String line = reader.readLine();
                if (line == null) break;
                if (line.contains("@"))
                    domainList.add(line.split("@")[1]);
            }
        } catch (IOException ex) {
        }
        return domainList.toArray(new String[domainList.size()]);
    }
}