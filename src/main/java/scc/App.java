package scc;

import scc.converterFunctionality.controller.ConverterStarter;
import scc.exception.DAOException;
import scc.view.UserInterface;

public class App {
    public static void main(String[] args) {
        ConverterStarter starter = new ConverterStarter(new UserInterface(), args);

        try {
            starter.runStarter();

        } catch (DAOException e) {
            System.out.println(e.getMessage());
        }
    }
}
