package server;

public class View {

    public String show(String data) {
        return data;
    }
    public String showError() {
        return "ERROR";
    }
    public String showOk() {
        return "OK";
    }
    public String showServerStarted(){
        return "Server started!";
    }
}