package scc.converterFunctionality.controller;

import scc.converterFunctionality.OutputFormat;
import scc.converterFunctionality.services.OutputFormatterFactory;
import scc.dao.FileReader;
import scc.view.UserInterface;

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
            handleParametrizedConversion(simpleCsvConverter);
        }
    }

    private void handleParametrizedConversion(SimpleCsvConverter simpleCsvConverter) {
        String givenFormatName = this.args[0];
        String pathToFile = this.args[1];

        if (OutputFormat.isAvailable(givenFormatName)) {
            OutputFormat expectedFormat = OutputFormat.getByName(givenFormatName);
            simpleCsvConverter.convert(pathToFile, expectedFormat);
        } else {
            userInterface.println("Given format name is not available.");
        }
    }

    private void handleNoAction() {
        userInterface.println("No input file defined");
    }
}
