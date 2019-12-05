package chatServer;

import packet.OPacket;
import packet.PacketManager;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientHandler extends Thread{
    private final Socket client;
    private String nickname = "Unknown";

    public ClientHandler (Socket client){
        this.client = client;
        start();
    }

    public String getNickname(){
        return nickname;
    }

    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    @Override
    public void run() {
         /*
        try {
            DataInputStream dis = new DataInputStream(
                    client.getInputStream());
            if(dis.available() > 0){
                //read and work with client request
                int var = dis.readInt();
                System.out.println("Received from client: " + var);
            }

        } catch (IOException e) { e.printStackTrace(); }
*/

        while(true){
            readData();
            if(!readData())
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) { e.printStackTrace(); }
        }

    }
    private boolean readData(){
        try {
            DataInputStream dis =  new DataInputStream(
                    client.getInputStream());
            if (dis.available() <= 0 )
                return false;
            short id = dis.readShort();
            //read packet
            OPacket packet = PacketManager.getPacket(id);
            packet.setSocket(client);
            packet.read(dis);

            //handle packet
            packet.handle();

        } catch (IOException e) { e.printStackTrace(); }

        return true;
    }

    public void invalidate(){
        ServerLoader.invalidate(client);
    }
}
