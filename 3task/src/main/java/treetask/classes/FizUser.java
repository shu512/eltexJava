package treetask.classes;

import java.io.FileWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class FizUser extends User {
    private String address;
    public FizUser(String name, String phone, String address) {
        super(name, phone);
        this.address = address;
    }

    public FizUser (String filename, String delim) {
        readFromCSV(filename, delim);
    }

    static public List<FizUser> getUsersFromDB (String databasename, String username, String password, String tablename) {
        List<FizUser> arrayList = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/" + databasename;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tablename);

            while(resultSet.next()) {
                FizUser temp = new FizUser("1", "1", "1");
                temp.setId(resultSet.getInt(1));
                temp.setName(resultSet.getString(2));
                temp.setPhone(resultSet.getString(3));
                temp.setAddress(resultSet.getString(4));
                arrayList.add(temp);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            return arrayList;
        }
    }

    @Override
    public void readFromBD(String databasename, String username, String password, String tablename) {
        String url = "jdbc:mysql://localhost:3306/" + databasename;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tablename);

            resultSet.first();
            setId(resultSet.getInt(1));
            setName(resultSet.getString(2));
            setPhone(resultSet.getString(3));
            setAddress(resultSet.getString(4));

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void writeInBD(String databasename, String username, String password, String tablename) {
        String url = "jdbc:mysql://localhost:3306/" + databasename;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String sqlRequest = "INSERT INTO " + tablename + " VALUES(" + getId() + ", '" + getName() +
                    "', '" + getPhone() + "', '" + getAddress() + "')";
            statement.executeUpdate(sqlRequest);

            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void readFromCSV(String filename, String delim) {
        super.readFromCSV(filename, delim);
        String[] parts = readArrayString(filename, delim);
        address = parts[3];
    }

    @Override
    public void writeInCSV(String filename, String delim) {
        super.writeInCSV(filename, delim);
        String temp = address + "\n";
        try (FileWriter fd = new FileWriter(filename, true)) {
            fd.write(temp);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}