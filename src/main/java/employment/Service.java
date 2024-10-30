package employment;

import employment.model.Query;

import java.util.List;

public class Service {
    public int findIndexOfElementInSubstring(List<String> dataFromFile, Query query) {
        String sequence = dataFromFile.get(1).toUpperCase();
        String substring = sequence.substring(query.getFirstIndex() - 1, query.getLastIndex());
        char charByIndex = substring.charAt(query.getSymbolIndex() - 1);
        int index = 0;
        for (int i = 0; i < query.getSymbolIndex(); i++) {
            if (charByIndex == substring.charAt(i)) {
                index++;
            }
        }
        return findCorrespondingElementInSubstring(substring, index, charByIndex);
    }

    private int findCorrespondingElementInSubstring(String substring, int index, char charByIndex) {
        int correspondingElementIndex = 0;
        for (int i = 0; i < substring.length(); i++) {
            if (substring.charAt(i) != charByIndex && correspondingElementIndex <= index) {
                correspondingElementIndex++;
            }
            if (correspondingElementIndex == index) {
                return i + 1;
            }
        }
        return -1;
    }
}
