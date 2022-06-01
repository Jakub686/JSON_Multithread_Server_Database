package server;


import server.requests.ClientRequest;

import server.requests.RequestPerson;
import server.requests.RequestString;

import java.io.IOException;

public class Controller {

    private Model model;
    private View view;
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }


    public ServerRespond run(RequestPerson input) throws IOException {
        ServerRespond serverRespond = new ServerRespond();
        //TODO Request from file and from console
        if (input.getType().equals("get")) {

            try {

                if (model.getList(input.getKey()) == null) {
                    serverRespond.response = view.showError();
                    serverRespond.reason = view.showNoSuchKey();

                } else {
                    serverRespond.response = view.showOk();
                    serverRespond.value = view.show(String.valueOf(model.getList(input.getKey())));
                }
            } catch (IOException e) {
                serverRespond.response = view.showError();
            }
        }
        if (input.getType().equals("set")) {
            try {
                model.setList(input.getKey(),input.getValue());
                serverRespond.response = view.showOk();

            } catch (Exception e) {
                serverRespond.response = view.showError();
            }
        }
        if (input.getType().equals("delete")) {
            try {
                if (model.getList(input.getKey()) == null) {
                    serverRespond.response = view.showError();
                    serverRespond.reason = view.showNoSuchKey();
                }else {
                    model.deleteList(input.getKey());
                    serverRespond.response = view.showOk();
                }
            } catch (IOException e) {
                serverRespond.response = view.showError();
                serverRespond.reason = view.showNoSuchKey();
            }
        }
        if (input.getType().equals("exit")) {
            try {
                serverRespond.response = view.showOk();
            } catch (Exception e) {
                serverRespond.response = view.showError();
            }
        }

        return serverRespond;
    }
    public ServerRespond run(RequestString input) throws IOException {
        ServerRespond serverRespond = new ServerRespond();
        //TODO Request from file and from console
        //System.out.println(input);
        if (input.getType().equals("get")) {
            try {

                if (model.getList(input.getKey()) == null) {
                    serverRespond.response = view.showError();
                    serverRespond.reason = view.showNoSuchKey();

                } else {
                    serverRespond.response = view.showOk();
                    serverRespond.value = view.show(String.valueOf(model.getList(input.getKey())));
                }
            } catch (IOException e) {
                serverRespond.response = view.showError();
            }
        }
        if (input.getType().equals("set")) {
            System.out.println("flow");
            try {
                model.setList(input.getKey(),input.getValue());

                serverRespond.response = view.showOk();

            } catch (Exception e) {
                serverRespond.response = view.showError();
            }
        }
        if (input.getType().equals("delete")) {
            try {
                if (model.getList(input.getKey()) == null) {
                    serverRespond.response = view.showError();
                    serverRespond.reason = view.showNoSuchKey();
                }else {
                    model.deleteList(input.getKey());
                    serverRespond.response = view.showOk();
                }
            } catch (IOException e) {
                serverRespond.response = view.showError();
                serverRespond.reason = view.showNoSuchKey();
            }
        }
        if (input.getType().equals("exit")) {
            try {
                serverRespond.response = view.showOk();
            } catch (Exception e) {
                serverRespond.response = view.showError();
            }
        }

        return serverRespond;
    }


}