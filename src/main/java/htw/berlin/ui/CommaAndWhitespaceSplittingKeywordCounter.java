package htw.berlin.ui;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class CommaAndWhitespaceSplittingKeywordCounter implements KeywordCounter {

    @Override
    public Map<String, Integer> countKeywords(String line, Set<String> keywords) {
        Map<String, Integer> keywordCount = new LinkedHashMap<>(); // to keep order of keywords
        List<String> splitInput = line != null ? Arrays.asList(line.split("[\\s,]+")) : Collections.emptyList();

        for (String keyword : keywords) {
            keywordCount.put(keyword, Collections.frequency(splitInput, keyword));
        }

        return keywordCount;
    }
}
