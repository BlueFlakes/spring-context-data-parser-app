package scc.services.starter;

import scc.models.OrdersProvider;

public class ConverterStarterFactory {
    public ConverterStarter getProperStarter(String[] args) {
        OrdersProvider ordersProvider = new OrdersProvider(args);
        int size = args.length;

        if (size == 0) {
            return new ZeroArgStarter();
        } else {
            return new MultipleArgsStarter(ordersProvider);
        }
    }
}