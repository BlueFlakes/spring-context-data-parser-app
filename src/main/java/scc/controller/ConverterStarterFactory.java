package scc.controller;

import scc.exception.InvalidArgsAmountException;

public class ConverterStarterFactory {
    public ConverterStarter getProperStarter(String[] args) throws InvalidArgsAmountException {
        switch (args.length) {
            case 0:
                return new ZeroArgStarter();

            case 1:
                return new OneArgStarter(args);

            case 2:
                return new ManyArgsStarter(args);

            default:
                throw new InvalidArgsAmountException("Incorrect amount of arguments delivered.");
        }
    }
}