package server;
// chyba moge wykozystac ta sama klase MyObject ktora jest w Cilient? Czy ta klasa jest nie potrzebna?
public class ReceiveObject {
    String type;
    int key;
    String value;



    public ReceiveObject(){

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
