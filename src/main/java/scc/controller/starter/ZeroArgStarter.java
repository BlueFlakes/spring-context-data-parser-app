package scc.controller.starter;

import scc.view.UserInterface;

public class ZeroArgStarter implements ConverterStarter {
    private UserInterface userInterface;

    public ZeroArgStarter(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @Override
    public void start() throws Exception {
        userInterface.println("No input defined.");
    }
}
