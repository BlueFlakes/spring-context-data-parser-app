package scc.converterFunctionality.services;

import scc.converterFunctionality.OutputFormat;

public class OutputFormatterFactory {
    private static final OutputFormat defaultOutputFormat = OutputFormat.TABLE;

    public OutputFormatter createByFormat(OutputFormat outputFormat) {
        switch (outputFormat) {
            case XML:
                return new XmlOutputFormatter();

            case JSON:
                return new JsonOutputFormatter();

            case TABLE:
                return new TableOutputFormatter();

            default:
                throw new IllegalArgumentException("Asked for non existing OutputFormatter");
        }
    }

    public OutputFormatter getDefaultOutputFormatter() {
        return createByFormat(defaultOutputFormat);
    }
}