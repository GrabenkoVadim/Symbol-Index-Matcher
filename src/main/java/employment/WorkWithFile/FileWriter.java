package employment.WorkWithFile;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriter {
    public void writeToFile(String filePath, String content) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(filePath, true))) {
            bufferedWriter.write(content);
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Cant write to file " + filePath, e);
        }
    }
}
