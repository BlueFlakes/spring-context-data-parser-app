package scc.controller.starter;

import scc.models.OrdersProvider;
import scc.view.UserInterface;

public class ConverterStarterFactory {
    public ConverterStarter getProperStarter(String[] args) {
        int size = args.length;

        if (size == 0) {
            return new ZeroArgStarter(new UserInterface());
        } else  {
            return new MultipleArgsStarter(new OrdersProvider(args));
        }
    }
}