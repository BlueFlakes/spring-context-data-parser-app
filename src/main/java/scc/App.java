package scc;


import scc.services.starters.ConverterStarterFactory;
import scc.services.starters.ConverterStarter;

public class App {
    public static void main(String[] args) {

        try {
            ConverterStarter starter = new ConverterStarterFactory().getProperStarter(args);
            starter.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
