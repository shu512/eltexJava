package thirdsubtask;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread {
    private Socket client;
    private int number;

    ServerThread(Socket client, int number) {
        this.number = number;
        this.client = client;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = client.getInputStream();
            OutputStream outputStream = client.getOutputStream();

            Scanner in = new Scanner(inputStream);
            PrintWriter out = new PrintWriter(outputStream);

            try (FileReader fd = new FileReader("Google.html") ) {
                String request = "";
                String stringFromFile = "";
                Scanner inFile = new Scanner(fd);
                while(inFile.hasNext()) {
                    stringFromFile += inFile.nextLine();
                }
                String answer = "HTTP/1.1 200 OK\nContent-Length: " + stringFromFile.length() + "\n\n" + stringFromFile;
                out.println(answer);
                out.flush();
                for (int i = 0; i < 15; i++) {
                    request += in.nextLine();
                }
                System.out.println(request);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            client.close();
            System.out.println("client " + number + " disconnected");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
