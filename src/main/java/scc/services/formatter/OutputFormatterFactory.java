package scc.services.formatter;

import scc.exception.ImproperArgumentException;

public class OutputFormatterFactory {
    public OutputFormatter createByFormat(OutputFormat outputFormat) throws ImproperArgumentException {
        switch (outputFormat) {
            case XML:
                return new XmlOutputFormatter();

            case JSON:
                return new JsonOutputFormatter();

            case TABLE:
                return new TableOutputFormatter();

            default:
                throw new ImproperArgumentException("Asked for non existing OutputFormatter");
        }
    }
}
