package employment;

import employment.WorkWithFile.FileReader;
import employment.WorkWithFile.FileWriter;
import employment.model.Query;

import java.util.List;

public class Main {
    private static final String INPUT_FILE_NAME = "input.txt";
    private static final String OUTPUT_FILE_NAME = "output.txt";

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();

        List<String> stringList = fileReader.readFile(INPUT_FILE_NAME);

        StringBuilder builder = new StringBuilder();

        List<Query> queries = new QueryParser().parseToQuery(stringList);
        for (Query query : queries) {
            int resultIndex = new Service().findIndexOfElementInSubstring(stringList, query);
            builder.append(resultIndex).append("\n");
        }
        FileWriter fileWriter = new FileWriter();
        fileWriter.writeToFile(OUTPUT_FILE_NAME, builder.toString());
    }
}