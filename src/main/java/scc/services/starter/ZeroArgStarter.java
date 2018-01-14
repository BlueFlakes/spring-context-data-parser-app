package scc.services.starter;

import org.springframework.stereotype.Component;
import scc.view.UserInterface;

@Component()
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
