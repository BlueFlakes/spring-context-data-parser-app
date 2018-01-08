package scc.controller;

import scc.enums.OutputFormat;

public class ManyArgsStarter implements ConverterStarter {

    private OutputFormat outputFormat;
    private String pathToFile;

    public ManyArgsStarter(String[] args) {
        String upperCaseFormatName = args[0].toUpperCase();
        this.outputFormat = OutputFormat.getByName(upperCaseFormatName);

        this.pathToFile = args[1];

        // TODO handle many args where many is >= 2
    }

    @Override
    public void start( ) throws Exception {

    }
}
