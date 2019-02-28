package treetask.classes;

import java.io.FileWriter;

public final class LegalUser extends User {
    private String nameCompany;
    public LegalUser(String name, String phone, String nameCompany) {
        super(name, phone);
        this.nameCompany = nameCompany;
    }

    public LegalUser (String filename, String delim) {
        readFromCSV(filename, delim);
    }

    @Override
    public void readFromCSV(String filename, String delim) {
        super.readFromCSV(filename, delim);
        String[] parts = readArrayString(filename, delim);
        nameCompany = parts[3];
    }

    @Override
    public void writeInCSV(String filename, String delim) {
        super.writeInCSV(filename, delim);
        String temp = nameCompany + "\n";
        try (FileWriter fd = new FileWriter(filename, true)) {
            fd.write(temp);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String getNameCompany() {
        return nameCompany;
    }
}
