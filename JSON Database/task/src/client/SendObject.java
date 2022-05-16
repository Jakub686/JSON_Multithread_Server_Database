package client;

public class SendObject {
    String type;
    int key;
    String value;

    public SendObject(String type, int key, String value) {
        this.type = type;
        this.key = key;
        this.value = value;
    }

    public SendObject(String type, int key) {
        this.type = type;
        this.key = key;
    }

    public SendObject(String type) {
        this.type = type;
    }

    public SendObject(){

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
