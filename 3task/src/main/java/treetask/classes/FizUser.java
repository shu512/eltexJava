package treetask.classes;

import java.io.FileWriter;

public final class FizUser extends User {
    private String address;
    public FizUser(String name, String phone, String address) {
        super(name, phone);
        this.address = address;
    }

    public FizUser (String filename, String delim) {
        readFromCSV(filename, delim);
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

}
