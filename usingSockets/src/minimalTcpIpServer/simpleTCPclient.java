package minimalTcpIpServer;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class simpleTCPclient {
    public static void main(String[] args) {
        try {
            Socket s1 = new Socket("127.0.0.1", 4000);
            InputStream is = s1.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            System.out.println(dis.readUTF());

            dis.close();
            s1.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Cant connect to the server!");
        }
    }
}
