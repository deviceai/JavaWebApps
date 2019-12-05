package chatClient;

import packet.OPacket;
import packet.PacketAuthorize;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientLoader {
    private static Socket socket;

    public static void main(String[] args) {
        connect();
        handle();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        end();
    }

    public static void sendPacket(OPacket packet){
        try {
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeShort(packet.getId());
            dos.flush();
        } catch (IOException e) { e.printStackTrace(); }
    }

    private static void handle() {

        sendPacket(new PacketAuthorize("Aleksandr"));
        /*
        try {

            DataOutputStream dos = new DataOutputStream(
                    socket.getOutputStream());
            dos.writeInt(112);
            dos.flush();

        } catch (IOException e) { e.printStackTrace(); }
        */
    }

    private static void connect(){
        try {
            socket = new Socket("127.0.0.1", 8000);

        } catch (IOException e) { e.printStackTrace(); }
    }
    private static void end() {
        try {
            socket.close();

        } catch (IOException e) { e.printStackTrace(); }
    }
}
