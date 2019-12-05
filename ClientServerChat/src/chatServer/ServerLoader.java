package chatServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerLoader {

    private static ServerSocket server;

    public static void main(String[] args) {
        serverStart();
        serverHandle();
        serverEnd();
    }

    private static void serverStart() {
        try {
            server = new ServerSocket(8000);

        } catch (IOException e) { e.printStackTrace(); }
    }

    private static void serverHandle() {
        // working with clients here

        while (true) {
            try {
                Socket client =  server.accept();
                new ClientHandler(client);

            } catch (IOException e) { e.printStackTrace(); }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e){}
        }
    }

    private static void serverEnd() {

        try {
            server.close();

        } catch (IOException e) { e.printStackTrace(); }
    }


}
