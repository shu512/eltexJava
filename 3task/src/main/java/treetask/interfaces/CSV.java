package treetask.interfaces;

public interface CSV {
    public void readFromCSV(String filename, String delim);
    public void writeInCSV(String filename, String delim);
    public String[] readArrayString(String filename, String delim);
}
