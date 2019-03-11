package treetask.interfaces;

public interface CSV {
    void readFromCSV(String filename, String delim);
    void writeInCSV(String filename, String delim);
    String[] readArrayString(String filename, String delim);
    void readFromBD(String databasename, String username, String password, String tablename);
    void writeInBD(String databasename, String username, String password, String tablename);
}
