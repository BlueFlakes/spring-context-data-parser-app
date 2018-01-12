package scc.services.formatter;

import org.springframework.stereotype.Component;
import scc.exception.ImproperArgumentException;
import scc.models.OrdersProvider;
import scc.models.OrdersInterpreter;

@Component
public class OutputFormatterFactory {
    public OutputFormatter createByFormat(OrdersProvider ordersProvider) throws ImproperArgumentException {
        OrdersInterpreter ordersInterpreter = new OrdersInterpreter(ordersProvider);
        OutputFormat outputFormat = ordersInterpreter.getOutputFormat();

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
