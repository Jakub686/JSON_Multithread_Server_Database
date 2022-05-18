package client;
// chyba moge wykozystac ta sama klase MyObject ktora jest w Cilient? Czy ta klasa jest nie potrzebna?
public class ServerRespond {
    String response;
    String reason;
    String value;

    public ServerRespond(String response, String reason, String value) {
        this.response = response;
        this.reason = reason;
        this.value = value;
    }



    public ServerRespond(){
    }


}
