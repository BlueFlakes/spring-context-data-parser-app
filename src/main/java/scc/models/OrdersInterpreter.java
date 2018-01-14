package scc.models;

import scc.exception.InvalidArgumentCombinationException;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

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

    public Optional<String> getGivenOutputFormatName() {
        List<String> basicSettings = this.ordersProvider.getBasicSettings();
        int settingsAmount = basicSettings.size();

        return settingsAmount == 2 ? Optional.of(basicSettings.get(0)) : Optional.empty();
    }

    public String getPrefixValueFromAdditionalInputs(final String keyPrefix) throws InvalidArgumentCombinationException {
        Supplier<String> errorMSg = () -> "Incorrect combination of arguments";

        return this.ordersProvider
                   .getAdditionalSettings().stream()
                                           .filter(s -> s.startsWith(keyPrefix))
                                           .filter(s -> s.length() > keyPrefix.length())
                                           .map(s -> s.substring(keyPrefix.length(), s.length()))
                                           .findFirst()
                                           .orElseThrow(() -> new InvalidArgumentCombinationException(errorMSg.get()));
    }
}
