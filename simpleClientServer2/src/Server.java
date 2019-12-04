import java.io.*;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {

        try ( ServerSocket server = new ServerSocket(7000))
        {
            System.out.println("Server started");

            while(true) {
                try (/*
                        Socket socket = server.accept();
                        OutputStream stream = socket.getOutputStream();
                        OutputStreamWriter streamWriter = new OutputStreamWriter(stream);
                        BufferedWriter writer = new BufferedWriter(streamWriter);

                        InputStream InStream = socket.getInputStream();
                        InputStreamReader InStreamReader = new InputStreamReader(InStream);
                        BufferedReader reader = new BufferedReader(InStreamReader);
                    */
                        Phone phone = new Phone(server);

                ) {
                    String request = phone.readLine();
                    System.out.println(request);

                    //while (!reader.readLine().isEmpty())
                      //  System.out.println(reader.readLine());

                    phone.writeline("HTTP/1.0 200 OK\n");
                    phone.writeline("Content-Type: text/html\n");
                    phone.writeline("<h1>TEST2</h1>\n");

                }
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }


    }
}
