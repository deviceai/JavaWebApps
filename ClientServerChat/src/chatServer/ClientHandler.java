package chatServer;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientHandler extends Thread{
    private final Socket client;

    public ClientHandler (Socket client){
        this.client = client;
        start();
    }

    @Override
    public void run() {
        try {
            DataInputStream dis = new DataInputStream(
                    client.getInputStream());
            if(dis.available() > 0){
                //read and work with client request
                int var = dis.readInt();
                System.out.println("Received from client: " + var);
            }
        } catch (IOException e) { e.printStackTrace(); }

        try {
            Thread.sleep(10);

        } catch (InterruptedException e) { e.printStackTrace(); }

    }
}
