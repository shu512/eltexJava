package treetask.interfaces;

public interface CSV {
    void readFromCSV(String filename, String delim);
    void writeInCSV(String filename, String delim);
    String[] readArrayString(String filename, String delim);
}
