package chatServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ServerLoader {

    private static ServerSocket server;
    private static ServerHandler handler;
    static Map<Socket, ClientHandler> handlers = new HashMap<>();

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
        handler = new ServerHandler(server);
        handler.start();
        readChat();
    }

    private static void readChat(){
        Scanner scan = new Scanner(System.in);
        while(true) {
            if (scan.hasNextLine()) {
                String line = scan.nextLine();
                System.out.println(line);
                if (line.equals("/end"))
                    serverEnd();
            } else
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {

                }
        }
    }

    public static ServerHandler getServerHandler(){
        return handler;
    }

    public static void serverEnd() {

        try {
            server.close();

        } catch (IOException e) { e.printStackTrace(); }
    }

    public static ClientHandler getHandler(Socket socket){
        return handlers.get(socket);
    }

    public static void invalidate(Socket socket){
        handlers.remove(socket);
    }

}
