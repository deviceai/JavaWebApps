import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("127.0.0.1", 4000);

        //byte[] bytes = new byte[256];
        //clientSocket.getInputStream().read(bytes);
        //System.out.println(new String(bytes));

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        String message = reader.readLine();
        System.out.println(message);

        clientSocket.close();

    }
}
