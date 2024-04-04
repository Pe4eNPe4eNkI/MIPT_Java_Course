package edu.phystech.hw2.analyzer;

import java.util.List;

public abstract class KeywordAnalyzer implements TextAnalyzer {
    private final List<String> valuesToBan;

    private final Label badCaseLabel;

    public KeywordAnalyzer(List<String> valuesToBan, Label label) {
        this.valuesToBan = valuesToBan;
        badCaseLabel = label;
    }


    public Label processText(String text) {
        List<String> splitText =  List.of(text.split(" "));
        for (var elem : splitText) {
            for (var banValue : valuesToBan) {
                if (banValue.equals(elem))
                    return badCaseLabel;
            }
        }
        return Label.OK;
    }
}