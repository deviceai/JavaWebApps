import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        try ( ServerSocket server = new ServerSocket(7000))
        {
            System.out.println("Server started");

            try (
                    Socket socket = server.accept();
                    OutputStream stream = socket.getOutputStream();
                    OutputStreamWriter streamWriter = new OutputStreamWriter(stream);
                    BufferedWriter writer = new BufferedWriter(streamWriter);
                ){
                    writer.write("Hello from server!");
                    writer.newLine();
                    writer.flush();
                }
        }

        catch (IOException e) {
            e.printStackTrace();
        }


    }
}
