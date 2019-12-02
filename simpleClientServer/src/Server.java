import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException{

        ServerSocket serverSocket = new ServerSocket(4000);
        int count = 0;
        while(true) {
            Socket clientSocket = serverSocket.accept();
            count++;
            System.out.println("client accepted " + count);
            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
            writer.write("<h2>Hello server</h2>");
            writer.flush();
            writer.close();
        }
        //clientSocket.close();

    }
}
