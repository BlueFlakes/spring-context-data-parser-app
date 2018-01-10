package scc.models;

import scc.exception.ImproperArgumentException;
import scc.services.formatter.OutputFormat;

import java.util.List;

public class CsvArgsInterpreter {
    private ArgsInterpreter argsInterpreter;

    public CsvArgsInterpreter(ArgsInterpreter argsInterpreter) {
        this.argsInterpreter = argsInterpreter;
    }

    public String getPath() {
        List<String> basicSettings = this.argsInterpreter.getBasicSettings();
        int settingsAmount = basicSettings.size();

        return settingsAmount == 2 ? basicSettings.get(1) : basicSettings.get(0);
    }

    private String getExpectedOutputFormatName() {
        List<String> basicSettings = this.argsInterpreter.getBasicSettings();
        int settingsAmount = basicSettings.size();

        return settingsAmount == 2 ? basicSettings.get(0) : null;
    }

    public OutputFormat getOutputFormat() throws ImproperArgumentException {
        String expectedOutputFormat = getExpectedOutputFormatName();

        if (expectedOutputFormat != null) {
            String upperCasedName = expectedOutputFormat.toUpperCase();
            OutputFormat outputFormat = OutputFormat.getByName(upperCasedName);

            if (outputFormat != null)
                return outputFormat;

            throw new ImproperArgumentException("Incorrect output formatter identity delivered.");
        }

        return OutputFormat.TABLE;
    }
}
