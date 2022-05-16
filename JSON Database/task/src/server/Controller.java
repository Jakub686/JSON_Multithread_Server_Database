package server;

import java.util.Scanner;

public class Controller {
    Scanner sc = new Scanner(System.in);

    //TODO dependency injection
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public String run(ReceiveObject input) {

        String result = "";
        //System.out.println(input);
        //String[] inputSplit = input.split(" ");

        if (input.type.equals("get")) {
            System.out.println(model.getList(input.key));
            try {
                if (model.getList(input.key) == null) {
                    result = view.showError();
                } else {
                    result = view.show(model.getList(input.key));
                }
            } catch (Exception e) {//idex out of  exception
                result = view.showError();
            }
        }
        if (input.type.equals("set")) {
            try {
                model.setList(input.key,input.value);
                result = view.showOk();
            } catch (Exception e) {
                result = view.showError();
            }
        }
        if (input.type.equals("delete")) {
            try {
                model.deleteList(input.key);
                result = view.showOk();
            } catch (Exception e) {
                result = view.showError();
            }
        }
        if (input.type.equals("exit")) {
            try {
                result = view.showOk();
            } catch (Exception e) {
                result = view.showError();
            }
        }

        return result;
    }

    public String text(String[] inputSplit) {
        String result = "";
        for (int i = 2; i < inputSplit.length; i++) {
            result += inputSplit[i] + " ";
        }
        return result;
    }
}