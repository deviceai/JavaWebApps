import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class whoIs {
    public static void main(String[] args) throws Exception{
        int c;
        Socket s = new Socket("internic.net", 43);
        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();

        //request string
        //String str = (args.length == 0 ? "google.com" : args[0]) + "\n";
        String str = "google.com";
        //convert to butes
        byte buf[] = str.getBytes();

        //sending request
        out.write(buf);

        //read and print response
        while ((c = in.read()) != -1){
            System.out.println((char) c);
        }

        //close socket
        s.close();
    }
}
