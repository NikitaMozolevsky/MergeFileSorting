package entity;

import java.util.List;

public class ParameterList {

    private boolean isInteger;
    private boolean isAscending = true;
    private String outFileName;
    private List<String> inFileNames;

    public ParameterList() {}

    public boolean isInteger() {
        return isInteger;
    }

    public void setInteger(boolean integer) {
        isInteger = integer;
    }

    public boolean isAscending() {
        return isAscending;
    }

    public void setAscending(boolean ascending) {
        isAscending = ascending;
    }

    public String getOutFileName() {
        return outFileName;
    }

    public void setOutFileName(String outFileName) {
        this.outFileName = outFileName;
    }

    public List<String> getInFileNames() {
        return inFileNames;
    }

    public void setInFileNames(List<String> inFileNames) {
        this.inFileNames = inFileNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParameterList that = (ParameterList) o;

        if (isInteger != that.isInteger) return false;
        if (isAscending != that.isAscending) return false;
        if (outFileName != null ? !outFileName.equals(that.outFileName) : that.outFileName != null) return false;
        return inFileNames != null ? inFileNames.equals(that.inFileNames) : that.inFileNames == null;
    }

    @Override
    public int hashCode() {
        int result = (isInteger ? 1 : 0);
        result = 31 * result + (isAscending ? 1 : 0);
        result = 31 * result + (outFileName != null ? outFileName.hashCode() : 0);
        result = 31 * result + (inFileNames != null ? inFileNames.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ParameterList{");
        sb.append("isInteger=").append(isInteger);
        sb.append(", isAscending=").append(isAscending);
        sb.append(", outFileName='").append(outFileName).append('\'');
        sb.append(", inFileNames=").append(inFileNames);
        sb.append('}');
        return sb.toString();
    }
}
