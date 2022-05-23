package server;

import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    private static final int PORT = 34522;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            boolean endLoop = true;
            Model model = new Model();
            View view = new View();
            ServerRespond serverRespond = new ServerRespond();
            Gson gson = new Gson();


            System.out.println("Server started!");
            while (endLoop) {
                try (
                        // accepting a new client
                        Socket socket = server.accept();
                        // Send and receive data
                        DataInputStream input = new DataInputStream(socket.getInputStream());
                        DataOutputStream output = new DataOutputStream(socket.getOutputStream())
                ) {

                    String jsonRequest = input.readUTF(); // reading a message
                    //System.out.println(jsonRequest);



                    //deserializtion
                    ClientRequest clientRequest = new Gson().fromJson(jsonRequest, ClientRequest.class);
                    //System.out.println(clientRequest);
                    //Input request to conntorel, receive respond
                    serverRespond = new Controller(model, view).run(clientRequest);

                    //Serlialization
                    String jsonRespond = gson.toJson(serverRespond);
                    output.writeUTF(jsonRespond); // resend it to the client
                    if(clientRequest.type.equals("exit"))
                        endLoop = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
