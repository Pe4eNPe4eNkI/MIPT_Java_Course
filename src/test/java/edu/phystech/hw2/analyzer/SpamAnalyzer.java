package edu.phystech.hw2.analyzer;

import java.util.List;

public class SpamAnalyzer extends KeywordAnalyzer {
    public SpamAnalyzer(List<String> valuesToBan) {
        super(valuesToBan, Label.SPAM);
    }
}
