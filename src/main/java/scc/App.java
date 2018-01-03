package scc;

import scc.converterFunctionality.ConverterController;
import scc.view.UserInterface;

public class App {
    private UserInterface userInterface;

    public App(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    private enum AppAction {
        FAILED,
        SUCCESSFULLY
    }

    public static void main(String[] args) {
        App app = new App(new UserInterface());
        AppAction action = app.getChosenAction(args);

        switch (action) {
            case SUCCESSFULLY:
                app.run(args);
                break;

            case FAILED:
                app.handleNoAction();
                break;

            default:
                throw new IllegalStateException("Application starter is corrupted.");
        }
    }

    private AppAction getChosenAction(String[] args) {
        return args.length == 0 ? AppAction.FAILED : AppAction.SUCCESSFULLY;
    }

    private void run(String[] args) {
        ConverterController converterController = new ConverterController();
        converterController.runController(args);
    }

    private void handleNoAction() {
        userInterface.println("No input file defined");
    }
}
