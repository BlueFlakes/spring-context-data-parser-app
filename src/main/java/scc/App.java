package scc;

import scc.converterFunctionality.controller.ConverterStarter;
import scc.view.UserInterface;

public class App {
    public static void main(String[] args) {
        ConverterStarter starter = new ConverterStarter(new UserInterface(), args);
        starter.runStarter();
    }
}
