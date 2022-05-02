package server;

public class View {

    // czy kazde wysietlenie, wrzyczac do View? w controlerze nie powinno byc nic z View? - TAK
    public void show(String data) {
        System.out.println(data);

    }

    public void showError() {
        System.out.println("ERROR");
    }

    public void showOk() {
        System.out.println("OK");
    }
}