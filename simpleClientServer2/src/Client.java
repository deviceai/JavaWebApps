import java.io.*;

public class Client {
    public static void main(String[] args) {
        try ( /*
                Socket socket = new Socket("127.0.0.1", 7000);
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(
                                socket.getOutputStream()));

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream()));
               */
            Phone phone = new Phone("127.0.0.1", 7000)

        ) {
            System.out.println("Connected to server");
            String request = "my request here";
            System.out.println("Request: " + request);

           phone.writeline(request);


            String response = phone.readLine();
            System.out.println("Response: " + response);


        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
