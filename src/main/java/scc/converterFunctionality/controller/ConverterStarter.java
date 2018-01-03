package scc.converterFunctionality.controller;

import scc.converterFunctionality.OutputFormat;
import scc.converterFunctionality.services.OutputFormatterFactory;
import scc.utils.dao.FileReader;
import scc.view.UserInterface;

import java.util.Optional;


public class ConverterStarter {

    private final UserInterface userInterface;
    private String[] args;

    public ConverterStarter(UserInterface userInterface, String[] args) {
        this.userInterface = userInterface;
        this.args = args;
    }

    private enum ConverterAction {
        FAILED,
        SUCCESFULLY_LOADED
    }

    public void runStarter() {
        ConverterAction action = getChosenAction();

        switch (action) {
            case SUCCESFULLY_LOADED:
                run();
                break;

            case FAILED:
                handleNoAction();
                break;

            default:
                throw new IllegalStateException("Application starter is corrupted.");
        }
    }

    private ConverterAction getChosenAction() {
        return this.args.length == 0 || this.args.length > 2 ? ConverterAction.FAILED : ConverterAction.SUCCESFULLY_LOADED;
    }

    private void run() {
        SimpleCsvConverter simpleCsvConverter = new SimpleCsvConverter(new FileReader(), new OutputFormatterFactory());

        if (this.args.length == 1) {
            String pathToFile = this.args[0];
            simpleCsvConverter.convert(pathToFile);

        } else if (this.args.length == 2) {
            handleParametrizedCommand(simpleCsvConverter);
        }
    }

    private void handleParametrizedCommand(SimpleCsvConverter simpleCsvConverter) {
        String expectedFormatName = this.args[0].toUpperCase();
        String pathToFile = this.args[1];

        Optional<OutputFormat> expectedFormat = OutputFormat.getByName(expectedFormatName);
        expectedFormat.ifPresent(outputFormat -> simpleCsvConverter.convert(pathToFile, outputFormat));
    }

    private void handleNoAction() {
        userInterface.println("No input file defined");
    }
}
