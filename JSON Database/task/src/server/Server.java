package server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import server.requests.ClientRequest;
import server.requests.RequestPerson;
import server.requests.RequestString;

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

    public void run() {
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
                    ClientRequest clientRequest = new ClientRequest();
                    RequestPerson requestPerson = new RequestPerson();
                    RequestString requestString = new RequestString();
                    //System.out.println("flow");
                    if(jsonRequest.contains(" \"key\":\"person\"")){
                        System.out.println("flow");
                        requestPerson = new Gson().fromJson(jsonRequest, RequestPerson.class);
                        requestPerson.setType(clientRequest.getType());
                        requestPerson.setKey(clientRequest.getKey());
                        requestPerson.setValue(clientRequest.getValue());
                        serverRespond = new Controller(model, view).run(requestPerson);
                    }
                    if(!jsonRequest.contains(" \"key\":\"person\"")){
                        requestString = new Gson().fromJson(jsonRequest, RequestString.class);
//                        requestString.setType(clientRequest.getType());
//                        System.out.println(clientRequest.getType());
//                        requestString.setKey(clientRequest.getKey());
//                        requestString.setValue(clientRequest.getValue().toString());
                        //System.out.println(requestString);
                        serverRespond = new Controller(model, view).run(requestString);

                    }


                    //deserializtion //TODO




                    //Input request to conntorel, receive respond
                    //serverRespond = new Controller(model, view).run(clientRequest);


//                 if(jsonRequest.contains("\"key\":\"person\"")) {
//                     //deserializtion //TODO
//                     System.out.println("flow");
//                     requestPerson = new Gson().fromJson(jsonRequest, RequestPerson.class);
//                     //Input request to conntorel, receive respond
//                     serverRespond = new Controller(model, view).run(requestPerson);
//                 }


//                 ClientRequest clientRequest = new Gson().fromJson(jsonRequest, ClientRequest.class);
//                 //Input request to conntorel, receive respond
//                 serverRespond = new Controller(model, view).run(clientRequest);

                    //Serlialization
                    String jsonRespond = new GsonBuilder().create().toJson(serverRespond);
                    output.writeUTF(jsonRespond); // resend it to the client
                    if (clientRequest.getType().equals("exit"))
                        endLoop = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
