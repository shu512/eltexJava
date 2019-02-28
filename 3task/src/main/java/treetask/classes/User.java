package treetask.classes;

import treetask.interfaces.CSV;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public abstract class User implements CSV {
    private static int index = 1;
    private int id;
    private String name;
    private String phone;

    User () {}

    User(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.id = index;
        index++;
    }

    @Override
    public String[] readArrayString(String filename, String delim) {
        String stringFromCSV = "";
        String[] parts = {};
        try (FileReader fd = new FileReader(filename) ) {
            Scanner in = new Scanner(fd);
            while(in.hasNext()) {
                stringFromCSV += in.next();
            }
            parts = stringFromCSV.split(delim);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return parts;
    }

    @Override
    public void readFromCSV(String filename, String delim) {
        try (FileReader fd = new FileReader(filename) ) {
            String[] parts = readArrayString(filename, delim);
            id = Integer.parseInt(parts[0]);
            name = parts[1];
            phone = parts[2];
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void writeInCSV(String filename, String delim) {
        String temp = id + delim + name + delim + phone + delim;
        try(FileWriter fileWriter = new FileWriter(filename)) {
            fileWriter.write(temp);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
