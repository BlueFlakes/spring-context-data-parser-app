package scc.services.printer;

import scc.models.OrdersProvider;

public enum PrinterFactories {
    ADVANCED,
    DEFAULT;

    public static PrinterFactories getTypeByOrders(OrdersProvider ordersProvider) {
        boolean wasUsedAdvancedOption = ordersProvider.getSearcher(PrinterType.class).isEnumWithGivenOptionAvailable();

        if (wasUsedAdvancedOption) {
            return PrinterFactories.ADVANCED;
        } else {
            return PrinterFactories.DEFAULT;
        }
    }
}
