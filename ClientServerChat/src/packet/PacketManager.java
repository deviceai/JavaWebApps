package packet;

import java.util.HashMap;
import java.util.Map;

public class PacketManager {

    private final static Map<Short, Class <? extends OPacket>> packets = new HashMap<>();

    static {
        packets.put((short) 1, PacketAuthorize.class);
    }

    public static OPacket getPacket(short id) {
        try {
            return packets.get(id).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        return null;

    }

    /*
    public static void read(short id, DataInputStream dis){
        try {
            OPacket packet = packets.get(id).newInstance();
            packet.read(dis);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     */
}
