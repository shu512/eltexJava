package thirdsubtask;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)) {
            int number = 0;
            final int MAX_CLIENTS = 10;
            ServerThread[] serverThread = new ServerThread[MAX_CLIENTS];

            System.out.println("server wait...");
            while(true) {
                Socket client = server.accept();
                System.out.println("client " + number + " connected.");
                serverThread[number] = new ServerThread(client, number);
                serverThread[number].start();
                number++;
                if (number == MAX_CLIENTS) {
                    System.out.println("server status: stop");
                    break;
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
