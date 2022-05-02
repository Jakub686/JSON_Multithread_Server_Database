package server;

public class Model {

    private String[] data = new String[101];

    public void setList(int index, String text) {
        data[index] = text;
    }

    public void deleteList(int index) {

        data[index] = null;
    }

    public String getList(int index) {

        return data[index];
    }

}