package scc.controller.starter;

import scc.controller.SimpleConverter;
import scc.models.InOutInputsAnalyser;
import scc.models.OrdersInterpreter;
import scc.models.OrdersProvider;
import scc.services.formatter.OutputFormat;
import scc.services.printer.PrinterType;

public class ManyArgsStarter implements ConverterStarter {
    private OrdersProvider ordersProvider;

    public ManyArgsStarter(OrdersProvider ordersProvider) {
        this.ordersProvider = ordersProvider;
    }

    @Override
    public void start( ) throws Exception {
        SimpleConverter simpleConverter = this.ordersProvider.getAppContext()
                                                             .getBean(SimpleConverter.class);
        simpleConverter.convert(this.ordersProvider);
    }
}
