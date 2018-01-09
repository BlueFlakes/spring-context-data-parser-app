package scc.models;

import java.util.List;

public class CsvArgsInterpreter {
    private ArgsInterpreter argsInterpreter;

    public CsvArgsInterpreter(ArgsInterpreter argsInterpreter) {
        this.argsInterpreter = argsInterpreter;
    }

    public String getPath() {
        List<String> basicSettings = this.argsInterpreter.getBasicSettings();
        int settingsAmount = basicSettings.size();

        return settingsAmount >= 2 ? basicSettings.get(1) : basicSettings.get(0);
    }
}
