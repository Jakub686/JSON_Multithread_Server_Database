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

    public void run() {
        boolean endCondition = true;

        do {
            String input = sc.nextLine();
            String[] inputSplit = input.split(" ");


            // czy pojedyncze CRUD w try check czy lepien cale?
            if (inputSplit[0].equals("get")) {
                try {
                    if (model.getList(Integer.parseInt(inputSplit[1])) == null) {
                        view.showError();
                    } else {
                        view.show(model.getList(Integer.parseInt(inputSplit[1])));
                    }
                } catch (Exception e) {//idex out of  exception
                    view.showError();
                }
            }
            if (inputSplit[0].equals("set")) {
                try {
                    model.setList(Integer.parseInt(inputSplit[1]), text(inputSplit));
                    view.showOk();
                } catch (Exception e) {
                    view.showError();
                }
            }
            if (inputSplit[0].equals("delete")) {
                try {
                    model.deleteList(Integer.parseInt(inputSplit[1]));
                    view.showOk();
                } catch (Exception e) {
                    view.showError();
                }
            }
            if (input.equals("exit")) {
                endCondition = false;
            }
        } while (endCondition);
    }

    public String text(String[] inputSplit) {
        String result = "";
        for (int i = 2; i < inputSplit.length; i++) {
            result += inputSplit[i] + " ";
        }
        return result;
    }
}