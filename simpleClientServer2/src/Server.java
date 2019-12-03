import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {  //Exception if binded port is busy
        ServerSocket server = new ServerSocket(7000);
        System.out.println("Server started");
        Socket socket = server.accept();
        System.out.println("Client connected");

        OutputStream stream = socket.getOutputStream();
        OutputStreamWriter streamWriter = new OutputStreamWriter(stream);
        BufferedWriter writer = new BufferedWriter(streamWriter);

        writer.write("Hello from server!");
        writer.newLine();
        writer.flush();

        writer.close();
        socket.close();
        server.close();

    }
}
