package edu.phystech.hw2.analyzer;

import java.util.List;

public abstract class KeywordAnalyzer implements TextAnalyzer {
    private final List<String> valuesToBan_;

    private final Label badCaseLabel_;

    public KeywordAnalyzer(List<String> valuesToBan, Label label) {
        this.valuesToBan_ = valuesToBan;
        badCaseLabel_ = label;
    }


    public Label processText(String text) {
        List<String> splitText =  List.of(text.split(" "));
        for (var elem : splitText) {
            for (var banValue : valuesToBan_) {
                if (banValue.equals(elem))
                    return badCaseLabel_;
            }
        }
        return Label.OK;
    }
}