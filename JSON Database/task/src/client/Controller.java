package client;

import java.util.Scanner;

public class Controller {
    Scanner sc = new Scanner(System.in);

    public void run() {
        boolean endCondition = true;
        Model model = new Model();
        View view = new View();

        do {
            String input = sc.nextLine();
            String[] inputSplit = input.split(" ");
            if (inputSplit[0].equals("get")) {
                if (model.getList(Integer.parseInt(inputSplit[1]))==null) {
                    view.showError();
                } else {
                    view.show(model.getList(Integer.parseInt(inputSplit[1])));
                }
            }
            if (inputSplit[0].equals("set")) {
                model.setList(Integer.parseInt(inputSplit[1]), inputSplit[2]);
            }
            if (inputSplit[0].equals("delete")) {
                model.deleteList(Integer.parseInt(inputSplit[1]));
            }
            if (input.equals("exit")) {
               endCondition = false;
            }

        } while (endCondition);
    }
}