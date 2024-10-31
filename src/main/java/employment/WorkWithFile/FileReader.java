package employment.WorkWithFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public List<String> readFile(String filePath) {
        List<String> dataFromFile = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(filePath), 64 * 1024)) {
            String line;
            while ((line = br.readLine()) != null) {
                dataFromFile.add(line);
            }
            if (dataFromFile.get(1).length() > 300_000) {
                throw new RuntimeException("It is too much characters in given String");
            }
            if (dataFromFile.size() > 300_002) {
                throw new RuntimeException("It is too much queries there");
            }
        } catch (IOException e) {
            throw new RuntimeException("Cant read file: " + filePath, e);
        }
        return dataFromFile;
    }
}
