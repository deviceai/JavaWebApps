package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class esp8266server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5555);

        while (true){
            Socket clientSocket =  server.accept();
            System.out.println("Client accepted");

            //client request reader
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader (clientSocket.getInputStream()));

            //writer for answering to client
            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());


            String request = reader.readLine();
            System.out.println("Client message is: " + request);

            writer.close();
            reader.close();
            clientSocket.close();


        }




    }
}
