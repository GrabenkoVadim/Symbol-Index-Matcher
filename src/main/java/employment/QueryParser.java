package employment;

import employment.model.Query;

import java.util.ArrayList;
import java.util.List;

public class QueryParser {
    private static final int RUN_START = 0;
    private static final int RUN_END = 1;
    private static final int SYMBOL_INDEX = 2;

    public List<Query> parseToQuery(List<String> dataFromFile) {
        List<Query> queries = new ArrayList<>();
        for (int i = 2; i < dataFromFile.size(); i++) {
            String[] splitedQuery = dataFromFile.get(i).split(" ");
            Query query = new Query();
            query.setFirstIndex(Integer.parseInt(splitedQuery[RUN_START]));
            query.setLastIndex(Integer.parseInt(splitedQuery[RUN_END]));
            query.setSymbolIndex(Integer.parseInt(splitedQuery[SYMBOL_INDEX]));
            if (query.getFirstIndex() <= query.getLastIndex()
                    && query.getSymbolIndex() > 0
                    && query.getSymbolIndex() <= query.getLastIndex()
                    && query.getLastIndex() < dataFromFile.get(1).length()) {
                queries.add(query);
            }
        }
        System.out.println("There could be some queries that are out of bounds. " +
                "They were skipped!");
        return queries;
    }
}
