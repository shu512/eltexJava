package firstfubtask;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)) {
            String getMsg;

            System.out.println("server wait...");

            Socket client = server.accept();
            System.out.println("connected.");

            InputStream inputStream = client.getInputStream();
            OutputStream outputStream = client.getOutputStream();

            Scanner in = new Scanner(inputStream);
            PrintWriter out = new PrintWriter(outputStream);

            while (true) {
                getMsg = in.nextLine().toUpperCase();
                out.println(getMsg);
                out.flush();
                if (getMsg.equals("BYE")) {
                    break;
                }
            }

            client.close();
            server.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
