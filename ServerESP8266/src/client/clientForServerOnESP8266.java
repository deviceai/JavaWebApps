package client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class clientForServerOnESP8266 {

    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("192.168.1.112", 5555);

        OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());

        String outputStr = "client here";
        writer.write(outputStr);

        writer.close();
        clientSocket.close();
    }
}
