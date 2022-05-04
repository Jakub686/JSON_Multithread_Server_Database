package client;

import java.io.*;
import java.net.Socket;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

public class Main {

    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 34522;

    public static void main(String[] args) {
        System.out.println("Client started");

            try (
                    Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                    DataInputStream input = new DataInputStream(socket.getInputStream());
                    DataOutputStream output = new DataOutputStream(socket.getOutputStream())
            ) {
//                Scanner scanner = new Scanner(System.in);
//                String msg = scanner.nextLine();

                //------------------------ Jcommander
                String msg= "";
                if(args.length == 2)
                    msg = args[1];

                if(args.length == 4)
                msg = args[1]+ " " + args[3];

                if(args.length == 6)
                    msg = args[1]+" " + args[3]+ " " + args[5];
                //----------------

                System.out.println("Sent: " + msg);
                output.writeUTF(msg); // sending message to the server
                String receivedMsg = input.readUTF(); // response message
                System.out.println("Received: " + receivedMsg);

            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}





