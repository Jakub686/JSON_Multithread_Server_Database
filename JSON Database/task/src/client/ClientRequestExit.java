package client;

public class ClientRequestExit {
    String type;


    public ClientRequestExit(String type) {
        this.type = type;
    }

    public ClientRequestExit() {
    }

    @Override
    public String toString() {
        return "ClientRequestExit{" +
                "type='" + type + '\'' +
                '}';
    }
}
