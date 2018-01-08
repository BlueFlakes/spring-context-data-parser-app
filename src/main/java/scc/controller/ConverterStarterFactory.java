package scc.controller;

import scc.dao.ReaderCreatorFactory;
import scc.exception.InvalidArgsAmountException;

public class ConverterStarterFactory {
    public ConverterStarter getProperStarter(String[] args) throws InvalidArgsAmountException {
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