package entity;

import java.util.List;

public class ResultOfSorting {

    private List<String> stringResult;
    private List<String> incorrectData;

    public ResultOfSorting() {
    }

    public ResultOfSorting(List<String> stringResult, List<String> incorrectData) {
        this.stringResult = stringResult;
        this.incorrectData = incorrectData;
    }

    public List<String> getStringResult() {
        return stringResult;
    }

    public void setStringResult(List<String> stringResult) {
        this.stringResult = stringResult;
    }

    public List<String> getIncorrectData() {
        return incorrectData;
    }

    public void setIncorrectData(List<String> incorrectData) {
        this.incorrectData = incorrectData;
    }
}
