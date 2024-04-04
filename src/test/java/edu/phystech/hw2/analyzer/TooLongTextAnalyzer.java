package edu.phystech.hw2.analyzer;

public class TooLongTextAnalyzer implements TextAnalyzer {
    private final int length;

    public TooLongTextAnalyzer(int length) {
        this.length = length;
    }

    @Override
    public Label processText(String text) {
        return text.length() < length ? Label.OK : Label.TOO_LONG;
    }
}

