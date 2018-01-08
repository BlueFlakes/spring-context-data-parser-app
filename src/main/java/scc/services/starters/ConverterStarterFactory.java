package scc.services.starters;

import scc.dao.ReaderCreatorFactory;

public class ConverterStarterFactory {
    public ConverterStarter getProperStarter(String[] args) {
        int size = args.length;

        if (size == 0) {
            return new ZeroArgStarter();
        } else if (size == 1) {
            return new OneArgStarter(args, new ReaderCreatorFactory());
        } else {
            return new ManyArgsStarter(args, new ReaderCreatorFactory());
        }
    }
}