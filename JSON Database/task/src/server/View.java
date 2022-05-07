package server;

// Moze mniejc klinet View, server contoler i model? taki podzial jest poprawny?
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