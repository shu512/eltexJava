package secondsubtask;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            String sendMsg;
            String getMsg;

            Socket socket = new Socket("localhost", 8080);

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            Scanner in = new Scanner(System.in);
            Scanner inSoc = new Scanner(inputStream);
            PrintWriter outSoc = new PrintWriter(outputStream);

            while (true) {
                sendMsg = in.nextLine();
                outSoc.println(sendMsg);
                outSoc.flush();
                getMsg = inSoc.nextLine();
                System.out.println(getMsg);
                if (getMsg.equals("BYE")) {
                    break;
                }
            }
            socket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
