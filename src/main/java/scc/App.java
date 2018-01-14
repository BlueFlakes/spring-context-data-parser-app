package scc;


import scc.services.starter.ConverterStarter;
import scc.services.starter.ConverterStarterFactory;

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
