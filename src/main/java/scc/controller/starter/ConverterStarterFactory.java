package scc.controller.starter;

import scc.models.OrdersInterpreter;

public class ConverterStarterFactory {
    public ConverterStarter getProperStarter(String[] args) {
        int size = args.length;

        if (size == 0) {
            return new ZeroArgStarter();
        } else  {
            return new MultipleArgsStarter(new OrdersInterpreter(args));
        }
    }
}