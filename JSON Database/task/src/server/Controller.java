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

    public String run(String input) {

        String result = "";
        System.out.println(input);
        String[] inputSplit = input.split(" ");

        if (inputSplit[0].equals("get")) {
            try {
                if (model.getList(Integer.parseInt(inputSplit[1])) == null) {
                    result = view.showError();
                } else {
                    result = view.show(model.getList(Integer.parseInt(inputSplit[1])));
                }
            } catch (Exception e) {//idex out of  exception
                result = view.showError();
            }
        }
        if (inputSplit[0].equals("set")) {
            try {
                model.setList(Integer.parseInt(inputSplit[1]), text(inputSplit));
                result = view.showOk();
            } catch (Exception e) {
                result = view.showError();
            }
        }
        if (inputSplit[0].equals("delete")) {
            try {
                model.deleteList(Integer.parseInt(inputSplit[1]));
                result = view.showOk();
            } catch (Exception e) {
                result = view.showError();
            }
        }
        if (inputSplit[0].equals("exit")) {
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