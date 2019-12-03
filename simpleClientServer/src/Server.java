import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException{

        ServerSocket serverSocket = new ServerSocket(8000);
        int count = 0;
        while(true) {
            Socket clientSocket = serverSocket.accept();
            count++;
            System.out.println("client accepted " + count);
            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            String request = reader.readLine();
            System.out.println("Client message is: " + request);
            String response = "You message length is " + request.length() + "\n";
            writer.write(response);

            /*writer.write("HTTP/1.0 200 OK\n" +
                    "Content-Type: text/html; charset=utf-8\n" +
                    "\n" +
                    "<p>My text</p>\n");

             */
            writer.flush();
            writer.close();
            reader.close();
        }
        //clientSocket.close();

    }
}
