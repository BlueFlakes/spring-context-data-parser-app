package scc.controller.starter;

import scc.models.ArgsInterpreter;

public class ManyArgsStarter implements ConverterStarter {
    private ArgsInterpreter argsInterpreter;

    public ManyArgsStarter(ArgsInterpreter argsInterpreter) {
        this.argsInterpreter = argsInterpreter;
    }

    @Override
    public void start( ) throws Exception {

    }
}
