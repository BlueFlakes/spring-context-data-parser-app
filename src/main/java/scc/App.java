package scc;


import scc.controller.starter.ConverterStarterFactory;
import scc.controller.starter.ConverterStarter;

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
