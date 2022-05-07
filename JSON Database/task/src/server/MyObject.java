package server;
// chyba moge wykozystac ta sama klase MyObject ktora jest w Cilient? Czy ta klasa jest nie potrzebna?
public class MyObject {
    String type;
    int key;
    String value;

    public MyObject(String type, int key, String value) {
        this.type = type;
        this.key = key;
        this.value = value;
    }
    public MyObject(){

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
