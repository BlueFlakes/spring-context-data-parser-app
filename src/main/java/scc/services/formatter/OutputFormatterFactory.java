package scc.services.formatter;

import org.springframework.stereotype.Component;
import scc.exception.ImproperArgumentException;
import scc.models.OrdersProvider;
import scc.models.OrdersInterpreter;

@Component
public class OutputFormatterFactory {
    public OutputFormatter createByFormat(OutputFormat outputFormat) throws ImproperArgumentException {

        if (outputFormat == OutputFormat.XML) {
            return new XmlOutputFormatter();
        }

        if (outputFormat == OutputFormat.JSON) {
            return new JsonOutputFormatter();
        }

        if (outputFormat == OutputFormat.TABLE) {
            return new TableOutputFormatter();
        }

        throw new ImproperArgumentException("Invalid argument delivered: " + outputFormat);
    }
}
