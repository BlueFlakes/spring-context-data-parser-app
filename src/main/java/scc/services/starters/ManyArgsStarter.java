package scc.services.starters;

import scc.dao.ReaderCreatorFactory;

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
