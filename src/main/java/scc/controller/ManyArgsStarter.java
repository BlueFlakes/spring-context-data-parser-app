package scc.controller;

import scc.dao.ReaderCreatorFactory;
import scc.enums.OutputFormat;

public class ManyArgsStarter implements ConverterStarter {
    private String[] args;
    private ReaderCreatorFactory readerCreatorFactory;

    public ManyArgsStarter(String[] args, ReaderCreatorFactory readerCreatorFactory) {
        this.args = args;
        this.readerCreatorFactory = readerCreatorFactory;
    }

    @Override
    public void start( ) throws Exception {

    }
}
