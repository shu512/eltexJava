package treetask.interfaces;

import java.util.List;

public interface DB {
    void readFromBD(String databasename, String username, String password, String tablename);
    void writeInBD(String databasename, String username, String password, String tablename);
    static List<?> getUsersFromDB(String databasename, String username, String password, String tablename) { return null; }
}
