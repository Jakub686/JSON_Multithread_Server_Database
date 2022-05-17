package client;

public class ClientRequest {
    String type;
    int key;
    String value;

    public ClientRequest(String type, int key, String value) {
        this.type = type;
        this.key = key;
        this.value = value;
    }

    public ClientRequest(String type, int key) {
        this.type = type;
        this.key = key;
    }

    public ClientRequest(String type) {
        this.type = type;
    }

    public ClientRequest(){

    }

    @Override
    public String toString() {
        return "MyObject{" +
                "type='" + type + '\'' +
                ", key=" + key +
                ", value='" + value + '\'' +
                '}';
    }
}
