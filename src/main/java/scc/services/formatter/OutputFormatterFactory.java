package scc.services.formatter;

import scc.enums.OutputFormat;
import scc.exception.InvalidOutputFormatterException;

public class OutputFormatterFactory {
    public OutputFormatter createByFormat(OutputFormat outputFormat) throws InvalidOutputFormatterException {
        switch (outputFormat) {
            case XML:
                return new XmlOutputFormatter();

            case JSON:
                return new JsonOutputFormatter();

            case TABLE:
                return new TableOutputFormatter();

            default:
                throw new InvalidOutputFormatterException("Asked for non existing OutputFormatter");
        }
    }
}
