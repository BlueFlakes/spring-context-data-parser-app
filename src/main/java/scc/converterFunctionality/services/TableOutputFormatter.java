package scc.converterFunctionality.services;

import java.util.Iterator;

public class TableOutputFormatter implements OutputFormatter {
    @Override
    public void printToConsole(Iterator<String> data) {
        System.out.println("TABLE output formatter");
    }
}
