package scc.controller;

import scc.enums.OutputFormat;
import scc.exception.InvalidOutputFormatterException;
import scc.services.converterServices.formatter.OutputFormatterConverterFactory;
import scc.dao.FileReader;
import scc.exception.DAOException;
import scc.view.UserInterface;

public class ConverterStarter {

    private final UserInterface userInterface;
    private String[] args;

    public ConverterStarter(UserInterface userInterface, String[] args) {
        this.userInterface = userInterface;
        this.args = args;
    }

    private enum ConverterAction {
        STOP,
        START
    }

    public void runStarter() throws DAOException {
        ConverterAction action = getChosenAction();

        switch (action) {
            case START:
                run();
                break;

            case STOP:
                handleNoAction();
                break;

            default:
                throw new IllegalStateException("Application starter is corrupted.");
        }
    }

    private ConverterAction getChosenAction() {
        return this.args.length == 0 || this.args.length > 2 ? ConverterAction.STOP : ConverterAction.START;
    }

    private void run() throws DAOException {
        try {
            convertFileContent();
        } catch (InvalidOutputFormatterException e) {
            this.userInterface.println(e.getMessage());
        }
    }

    private void convertFileContent() throws DAOException, InvalidOutputFormatterException {
        SimpleCsvConverter simpleCsvConverter = new SimpleCsvConverter(new FileReader());

        if (this.args.length == 1) {
            String pathToFile = this.args[0];
            simpleCsvConverter.convert(pathToFile);

        } else if (this.args.length == 2) {
            handleParametrizedConversion(simpleCsvConverter);

        }
    }

    private void handleParametrizedConversion(SimpleCsvConverter simpleCsvConverter) throws InvalidOutputFormatterException {
        String givenFormatName = this.args[0];
        String pathToFile = this.args[1];

        OutputFormat expectedFormat = OutputFormat.getByName(givenFormatName);
        simpleCsvConverter.convert(pathToFile, expectedFormat);
    }

    private void handleNoAction() {
        userInterface.println("No input file defined");
    }
}
