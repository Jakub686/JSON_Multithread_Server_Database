package server;


public class Controller {

    //TODO dependency injection
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }


    public ServerRespond run(ClientRequest input) {
        ServerRespond serverRespond = new ServerRespond();

        if (input.type.equals("get")) {
            System.out.println(model.getList(input.key));
            try {
                if (model.getList(input.key) == null) {
                    serverRespond.response = view.showError();
                    serverRespond.reason = view.showNoSuchKey();

                } else {
                    serverRespond.response = view.showOk();
                    serverRespond.value = view.show(model.getList(input.key));
                }
            } catch (Exception e) {//index out of  exception
                serverRespond.response = view.showError();
            }
        }
        if (input.type.equals("set")) {
            try {
                model.setList(input.key,input.value);
                serverRespond.response = view.showOk();
            } catch (Exception e) {
                serverRespond.response = view.showError();
            }
        }
        if (input.type.equals("delete")) {
            try {
                if (model.getList(input.key) == null) {
                    serverRespond.response = view.showError();
                    serverRespond.reason = view.showNoSuchKey();
                }else {
                    model.deleteList(input.key);
                    serverRespond.response = view.showOk();
                }
            } catch (Exception e) {
                serverRespond.response = view.showError();
                serverRespond.reason = view.showNoSuchKey();
            }
        }
        if (input.type.equals("exit")) {
            try {
                serverRespond.response = view.showOk();
            } catch (Exception e) {
                serverRespond.response = view.showError();
            }
        }

        return serverRespond;
    }

}