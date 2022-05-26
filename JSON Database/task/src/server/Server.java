package server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


//sever have to implement runnable
public class Server implements Runnable {

    private final int port;
    private final ExecutorService executor;
    private ServerSocket server;

    public Server(int port, String filePath) {
        this.port = port;
        this.executor = Executors.newCachedThreadPool();
    }

    public void run(){
     try (ServerSocket server = new ServerSocket(port)) {

         boolean endLoop = true;
         Model model = new Model();
         View view = new View();
         ServerRespond serverRespond = new ServerRespond();



         System.out.println("Server started!");
         while (endLoop) {
             try (
                     // accepting a new client
                     Socket socket = server.accept();
                     // Send and receive data
                     DataInputStream input = new DataInputStream(socket.getInputStream());
                     DataOutputStream output = new DataOutputStream(socket.getOutputStream())
             ) {
                 String jsonRequest = input.readUTF(); // reading a message from client

                 //deserializtion
                 ClientRequest clientRequest = new Gson().fromJson(jsonRequest, ClientRequest.class);
                 //Input request to conntorel, receive respond
                 serverRespond = new Controller(model, view).run(clientRequest);

                 //Serlialization
                 String jsonRespond = new GsonBuilder().create().toJson(serverRespond);
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
