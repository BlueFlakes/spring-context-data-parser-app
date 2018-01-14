package scc.controller.starter;

import scc.models.OrdersProvider;

public class ConverterStarterFactory {
    public ConverterStarter getProperStarter(String[] args) {
        OrdersProvider ordersProvider = new OrdersProvider(args);
        int size = args.length;

        if (size == 0) {
            return ordersProvider.getAppContext()
                                 .getBean(ZeroArgStarter.class);
        } else  {
            return new MultipleArgsStarter(ordersProvider);
        }
    }
}