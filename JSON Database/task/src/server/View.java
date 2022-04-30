package server;

public class View {

    public void show(String data){
        System.out.println(data);
    }

    public void showError(){
        System.out.println("ERROR");
    }
    public void showOk(){
        System.out.println("OK");
    }
}