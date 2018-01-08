package scc.controller;

public class OneArgStarter implements ConverterStarter {
    private String pathToFile;

    public OneArgStarter(String[] args) {
        this.pathToFile = args[0];
    }

    @Override
    public void start( ) throws Exception {

    }
}