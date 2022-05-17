package server;

public class ClientRequest {
    String type;
    int key;
    String value;

    public ClientRequest(String type, int key, String value) {
        this.type = type;
        this.key = key;
        this.value = value;
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
