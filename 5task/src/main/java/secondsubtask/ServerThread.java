package secondsubtask;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
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

            while (true) {
                String getMsg = in.nextLine().toUpperCase();
                out.println(getMsg);
                out.flush();
                if (getMsg.equals("BYE")) {
                    break;
                }
            }
            client.close();
            System.out.println("client " + number + " disconnected");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
