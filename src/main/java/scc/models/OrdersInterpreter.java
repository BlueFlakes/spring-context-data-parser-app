package scc.models;

import scc.exception.ImproperArgumentException;
import scc.services.formatter.OutputFormat;

import java.util.List;

public class OrdersInterpreter {
    private OrdersProvider ordersProvider;

    public OrdersInterpreter(OrdersProvider ordersProvider) {
        this.ordersProvider = ordersProvider;
    }

    public String getPath() {
        List<String> basicSettings = this.ordersProvider.getBasicSettings();
        int settingsAmount = basicSettings.size();

        return settingsAmount == 2 ? basicSettings.get(1) : basicSettings.get(0);
    }

    private String getExpectedOutputFormatName() {
        List<String> basicSettings = this.ordersProvider.getBasicSettings();
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

        return null;
    }
}
