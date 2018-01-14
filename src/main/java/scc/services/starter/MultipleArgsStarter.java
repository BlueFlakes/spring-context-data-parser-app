package scc.services.starter;

import scc.controller.SimpleConverter;
import scc.models.OrdersProvider;

public class MultipleArgsStarter implements ConverterStarter {
    private OrdersProvider ordersProvider;

    public MultipleArgsStarter(OrdersProvider ordersProvider) {
        this.ordersProvider = ordersProvider;
    }

    @Override
    public void start( ) throws Exception {
        SimpleConverter simpleConverter = this.ordersProvider.getAppContext()
                                                             .getBean(SimpleConverter.class);
        simpleConverter.convert(this.ordersProvider);
    }
}
