package employment;

import employment.WorkWithFile.FileReader;
import employment.WorkWithFile.FileWriter;
import employment.model.Query;

import java.util.List;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/java/employment/data/input.txt";
    private static final String OUTPUT_FILE_NAME = "src/main/java/employment/data/output.txt";

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        List<String> stringList = fileReader.readFile(INPUT_FILE_NAME);

        List<Query> queries = new QueryParser().parseToQuery(stringList);
        Service service = new Service();
        int counter = 0;
        for (Query query : queries) {

            counter++;
            if (counter == 18) {
                System.out.println("");
            }

            int resultIndex = service.findIndexOfElementInSubstring(stringList, query);
            FileWriter fileWriter = new FileWriter();
            fileWriter.writeToFile(OUTPUT_FILE_NAME, String.valueOf(resultIndex));
        }
    }
}