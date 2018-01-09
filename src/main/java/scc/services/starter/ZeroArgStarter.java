package scc.services.starter;

import scc.view.UserInterface;

public class ZeroArgStarter implements ConverterStarter {
    private UserInterface userInterface = new UserInterface();

    @Override
    public void start() throws Exception {
        userInterface.println("No input defined.");
    }
}
