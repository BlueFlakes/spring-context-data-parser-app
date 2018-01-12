package scc.services.formatter;

import scc.exception.ImproperArgumentException;
import scc.models.OrdersProvider;
import scc.models.BasicArgsInterpreter;


public class OutputFormatterFactory {
    public OutputFormatter createByFormat(OrdersProvider ordersProvider) throws ImproperArgumentException {
        BasicArgsInterpreter basicArgsInterpreter = new BasicArgsInterpreter(ordersProvider);
        OutputFormat outputFormat = basicArgsInterpreter.getOutputFormat();

        if (outputFormat != null) {
            switch (outputFormat) {
                case XML:
                    return new XmlOutputFormatter();

                case JSON:
                    return new JsonOutputFormatter();

                case TABLE:
                    return new TableOutputFormatter();
            }
        }

        return new TableOutputFormatter();
    }
}
