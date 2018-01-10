package scc.services.formatter;

import scc.exception.CustomInvalidArgumentException;

public class OutputFormatterFactory {
    public OutputFormatter createByFormat(OutputFormat outputFormat) throws CustomInvalidArgumentException {
        switch (outputFormat) {
            case XML:
                return new XmlOutputFormatter();

            case JSON:
                return new JsonOutputFormatter();

            case TABLE:
                return new TableOutputFormatter();

            default:
                throw new CustomInvalidArgumentException("Asked for non existing OutputFormatter");
        }
    }
}
