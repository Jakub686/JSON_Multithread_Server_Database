package server;

public class View {

    // czy kazde wysietlenie, wrzyczac do View? w controlerze nie powinno byc nic z View? - TAK
    public String show(String data) {
        return data;

    }

    public String showError() {

        return "ERROR";
    }

    public String showOk() {

        return "OK";
    }
}